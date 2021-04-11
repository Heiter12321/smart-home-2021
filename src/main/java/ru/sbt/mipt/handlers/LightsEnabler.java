package ru.sbt.mipt.handlers;

import ru.sbt.mipt.components.Action;
import ru.sbt.mipt.components.Light;
import ru.sbt.mipt.components.SmartHome;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

public class LightsEnabler implements Handler {
    private final SmartHome home;

    public LightsEnabler(SmartHome home) {
        this.home = home;
    }

    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == SensorEventType.LIGHT_ENABLE_ALL) {
            Action action = (Object obj) -> {
                if (obj instanceof Light) {
                    Light light = (Light)obj;
                    light.setOn(true);
                }
            };
            home.execute(action);
        }
    }
}
