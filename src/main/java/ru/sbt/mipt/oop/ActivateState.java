package ru.sbt.mipt.oop;

public class ActivateState implements SignalingState {
    Signaling signaling;
    ActivateState(Signaling signaling) {
        this.signaling = signaling;
    }

    @Override
    public void activate(String code) {}

    @Override
    public void deactivate(String code) {
        if (code.equals(signaling.code)) {
            signaling.changeState(new DeactivateState(signaling));
        } else {
            signaling.changeState(new AlarmState(signaling));
        }
    }

    @Override
    public void setAlarm() {
        signaling.changeState(new AlarmState(signaling));
    }
}
