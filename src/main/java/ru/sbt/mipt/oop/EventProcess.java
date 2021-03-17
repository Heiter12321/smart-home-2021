package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorSensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.DoorSensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.LightSensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.LightSensorEventType.LIGHT_ON;

public class EventProcess {
    void processingEvent(SmartHome smartHome, SensorEvent event) {
        SensorEventType type = event.getType();
        if (LIGHT_ON.equals(type) || LIGHT_OFF.equals(type)) {
            LightEventProcessor lightEventProcessor = new LightEventProcessor(smartHome, event);
            lightEventProcessor.processingEvent();
        } else if (DOOR_OPEN.equals(type) || DOOR_CLOSED.equals(type)) {
            DoorEventProcessor doorEventProcessor = new DoorEventProcessor(smartHome, event);
            doorEventProcessor.processingEvent();
        }
    }
}
