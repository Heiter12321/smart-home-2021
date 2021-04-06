package ru.sbt.mipt.oop;

public class LightEvent extends SensorEvent {
    private final SensorEventType type;
    private final String objectId;

    public LightEvent(SensorEventType type, String objectId) {
        super(type, objectId);
        this.type = type;
        this.objectId = objectId;
    }

    public SensorEventType getType() {
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
