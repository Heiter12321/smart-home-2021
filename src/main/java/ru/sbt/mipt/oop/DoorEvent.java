package ru.sbt.mipt.oop;

public class DoorEvent extends SensorEvent {
    private final SensorEventType type;
    private final String objectId;

    public DoorEvent(SensorEventType type, String objectId) {
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
