package ru.sbt.mipt.oop;

import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor extends EventProcess {
    private final Collection<Door> doors;

    public DoorEventProcessor(Collection<Door> doors) {
        this.doors = doors;
    }

    @Override
    public void processingEvent(SmartHome smartHome, Event event) {
        doors.forEach(door -> {
            if (door.getId().equals(event.getObjectId())) {
                if (smartHome.signaling.state.getClass().isInstance(ActivateState.class)) {
                    smartHome.signaling.changeState(new AlarmState(smartHome.signaling));
                    new SMSSender(smartHome).sendSMS();
                    return;
                }
                if (smartHome.signaling.state.getClass().isInstance(AlarmState.class)) {
                    return;
                }
                if (event.getType() == DOOR_OPEN) {
                    door.setOpen(true);
                    System.out.println("Door " + door.getId() + " was opened.");
                } else {
                    door.setOpen(false);
                    System.out.println("Door " + door.getId() + " was closed.");
                }
            }
        });
    }
}
