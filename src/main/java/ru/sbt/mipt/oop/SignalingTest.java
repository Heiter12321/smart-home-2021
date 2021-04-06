package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignalingTest {

    @Test
    void activate() {
        Signaling signaling = new Signaling("password");
        signaling.activate("anime");
        assertEquals(signaling.state.getClass(), DeactivateState.class);
        signaling.activate("password");
        assertEquals(signaling.state.getClass(), ActivateState.class);
    }

    @Test
    void deactivate() {
        Signaling signaling = new Signaling("password");
        signaling.activate("password");
        signaling.deactivate("password");
        assertEquals(signaling.state.getClass(), DeactivateState.class);
    }

    @Test
    void setAlarm() {
        Signaling signaling = new Signaling("password");
        signaling.activate("password");
        signaling.deactivate("anime");
        assertEquals(signaling.state.getClass(), AlarmState.class);
    }

    @Test
    void changeState() {
        Signaling signaling = new Signaling("password");
        signaling.changeState(new AlarmState(signaling));
        assertEquals(signaling.state.getClass(), AlarmState.class);
    }
}