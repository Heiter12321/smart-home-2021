package ru.sbt.mipt.oop;

interface SignalingState {
    Signaling signaling = null;

    void activate(String code);

    void deactivate(String code);

    void setAlarm();
}
