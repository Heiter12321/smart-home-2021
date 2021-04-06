package ru.sbt.mipt.oop;

import java.util.Collection;

public class HallDoorEventProcessor extends EventProcess {
    private final Collection<Light> lights;
    private final SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome, Collection<Light> lights) {
        this.lights = lights;
        this.smartHome = smartHome;
    }

    public void setLightOffAroundHome() {
        if (smartHome.signaling.state.getClass().isInstance(ActivateState.class)) {
            smartHome.signaling.changeState(new AlarmState(smartHome.signaling));
            new SMSSender(smartHome).sendSMS();
            return;
        }

        if (smartHome.signaling.state.getClass().isInstance(AlarmState.class)) {
            return;
        }
        lights.forEach(light -> light.setOn(false));
    }

    @Override
    public void processingEvent(SmartHome smartHome, Event event) {
        setLightOffAroundHome();
    }
}
