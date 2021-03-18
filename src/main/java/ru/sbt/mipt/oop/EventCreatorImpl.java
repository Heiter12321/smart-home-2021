package ru.sbt.mipt.oop;

public class EventCreatorImpl implements EventCreator{
    public EventCreatorImpl() {}

    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        int numberEventType = (int) (4 * Math.random());
        SensorEventType sensorEventType;
        String objectId = "" + ((int) (10 * Math.random()));
        if (numberEventType > 1) {
            sensorEventType = SensorEventType.values()[numberEventType - 2];
            return new DoorSensorEvent(sensorEventType, objectId);
        } else {
            sensorEventType = SensorEventType.values()[numberEventType];
            return new LightSensorEvent(sensorEventType, objectId);
        }
    }
}
