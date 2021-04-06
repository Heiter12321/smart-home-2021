package ru.sbt.mipt.oop;

public class SignalingEvent implements Event{
    private final SignalingEventType type;
    private final String objectId;

    public SignalingEvent(SignalingEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public EventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SignalingSensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
