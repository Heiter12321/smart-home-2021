package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorSensorEventType.DOOR_OPEN;

public class DoorEventProcessor extends EventProcess {
    private final SmartHome smartHome;
    private final SensorEvent event;

    public DoorEventProcessor(SmartHome smartHome, SensorEvent event) {
        this.smartHome = smartHome;
        this.event = event;
    }

    public void processingEvent() {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                        if (room.getName().equals("hall")) {
                            HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(smartHome);
                            hallDoorEventProcessor.setLightOffAroundHome();
                        }
                    }
                }
            }
        }
    }
}
