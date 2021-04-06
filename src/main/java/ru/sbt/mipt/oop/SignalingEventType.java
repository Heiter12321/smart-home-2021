package ru.sbt.mipt.oop;

public enum SignalingEventType implements EventType {
    ALARM_ACTIVATE("password"), ALARM_DEACTIVATE("password");

    public final String code;

    SignalingEventType(String code) {
        this.code = code;
    }
}
