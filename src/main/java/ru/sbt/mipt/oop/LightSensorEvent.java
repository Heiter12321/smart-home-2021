package ru.sbt.mipt.oop;

public class LightSensorEvent implements SensorEvent{
    private final LightSensorEventType type;
    private final String objectId;

    public LightSensorEvent(LightSensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public LightSensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "DoorSensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
