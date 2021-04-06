package ru.sbt.mipt.oop;

public class AlarmState implements SignalingState {
    Signaling signaling;
    AlarmState(Signaling signaling) {
        this.signaling = signaling;
    }

    @Override
    public void activate(String code) {}

    @Override
    public void deactivate(String code) {
        if (code.equals(signaling.code)) {
            signaling.changeState(new DeactivateState(signaling));
        }
    }

    @Override
    public void setAlarm() {}
}
