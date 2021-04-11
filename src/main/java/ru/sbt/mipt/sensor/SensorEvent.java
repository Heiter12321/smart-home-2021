package ru.sbt.mipt.sensor;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private final String code;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
        this.code = "";
    }

    public SensorEvent(SensorEventType type) {
        this.type = type;
        this.objectId = "";
        this.code = "";
    }

    public SensorEvent(SensorEventType type, String objectId, String code) {
        this.type = type;
        this.objectId = objectId;
        this.code = code;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getCode() {
        return this.code;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
