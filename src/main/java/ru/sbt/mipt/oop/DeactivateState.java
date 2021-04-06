package ru.sbt.mipt.oop;

public class DeactivateState implements SignalingState {
    Signaling signaling;
    DeactivateState(Signaling signaling) {
        this.signaling = signaling;
    }

    @Override
    public void activate(String code) {
        if (code.equals(signaling.code)) {
            signaling.changeState(new ActivateState(signaling));
        }
    }

    @Override
    public void deactivate(String code) {}

    @Override
    public void setAlarm() {
        signaling.changeState(new AlarmState(signaling));
    }
}
