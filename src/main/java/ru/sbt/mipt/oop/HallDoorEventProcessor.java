package ru.sbt.mipt.oop;

import java.util.Collection;

public class HallDoorEventProcessor implements EventProcess {
    private final Collection<Light> lights;

    public HallDoorEventProcessor(Collection<Light> lights) {
        this.lights = lights;
    }

    public void setLightOffAroundHome() {
        lights.forEach(light -> {
            light.setOn(false);
        });
    }

    @Override
    public void processingEvent(SensorEvent event) {
        setLightOffAroundHome();
    }
}
