package ru.sbt.mipt.handlers;

import ru.sbt.mipt.components.Action;
import ru.sbt.mipt.components.Door;
import ru.sbt.mipt.components.SmartHome;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

public class EntranceDoorCloser implements Handler{
    private final SmartHome home;

    public EntranceDoorCloser(SmartHome home) {
        this.home = home;
    }

    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == SensorEventType.ENTRANCE_DOOR_CLOSED) {
            Action action = (Object obj) -> {
                if (obj instanceof Door) {
                    Door door = (Door) obj;
                    if (door.isEntrance()) {
                        door.setOpen(false);
                    }
                }
            };

            home.execute(action);
        }
    }
}
