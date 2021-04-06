package ru.sbt.mipt.oop;

import java.util.Collection;

public class HallDoorEventProcessor extends EventProcess {
    private final Collection<Light> lights;
    private final SmartHome smartHome;
    private final SMSSender smsSender;

    public HallDoorEventProcessor(SmartHome smartHome, Collection<Light> lights, SMSSender smsSender) {
        this.lights = lights;
        this.smartHome = smartHome;
        this.smsSender = smsSender;
    }

    public void setLightOffAroundHome() {
        if (smartHome.signaling.state.getClass().isInstance(ActivateState.class)) {
            smartHome.signaling.changeState(new AlarmState(smartHome.signaling));
            smsSender.sendSMS();
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
