package ru.sbt.mipt.oop;

public class Signaling {
    SignalingState state;
    String code;

    public Signaling(String code) {
        this.state = new DeactivateState(this);
        this.code = code;
    }

    public void activate(String code) {
        state.activate(code);
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

    public void setAlarm() {
        state.setAlarm();
    }

    void changeState(SignalingState state) {
        this.state = state;
    }
}
