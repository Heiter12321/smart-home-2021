package ru.sbt.mipt.oop;

public class DoorSensorEvent implements SensorEvent{
    private final DoorSensorEventType type;
    private final String objectId;

    public DoorSensorEvent(DoorSensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public DoorSensorEventType getType() {
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
