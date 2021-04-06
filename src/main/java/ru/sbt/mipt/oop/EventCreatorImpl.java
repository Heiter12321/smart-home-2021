package ru.sbt.mipt.oop;

public class EventCreatorImpl implements EventCreator{
    public EventCreatorImpl() {}

    public Event getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        int numberEventType = (int) (6 * Math.random());
        EventType eventType;
        String objectId = "" + ((int) (10 * Math.random()));
        if (numberEventType <= 1) {
            eventType = SensorEventType.values()[numberEventType - 2];
            return new DoorEvent((SensorEventType) eventType, objectId);
        } else if (numberEventType <= 3){
            eventType = SensorEventType.values()[numberEventType];
            return new LightEvent((SensorEventType) eventType, objectId);
        } else {
            eventType = SignalingEventType.values()[numberEventType - 4];
            return new SignalingEvent((SignalingEventType) eventType, objectId);
        }
    }
}
