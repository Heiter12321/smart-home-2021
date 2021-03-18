package ru.sbt.mipt.oop;

public class EventDistributor {
    public EventProcess getNeededEventProcessor(SmartHome smartHome, SensorEvent event) {
        switch (event.getType()) {
            case LIGHT_ON:
            case LIGHT_OFF:
                return new LightEventProcessor(smartHome, event);
            case DOOR_OPEN:
            case DOOR_CLOSED:
                return new DoorEventProcessor(smartHome, event);
            default:
                return new HallDoorEventProcessor(smartHome);
        }
    }
}
