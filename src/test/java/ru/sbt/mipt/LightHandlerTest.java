package ru.sbt.mipt;

import org.junit.Test;
import ru.sbt.mipt.components.Action;
import ru.sbt.mipt.components.Light;
import ru.sbt.mipt.components.SmartHome;
import ru.sbt.mipt.handlers.LightHandler;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LightHandlerTest {
    private Light testLight;

    @Test
    public void checksIfLightIsTurnedOff() {
        SmartHome home = HomeBuilder.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, "3");
        LightHandler lightHandler = new LightHandler(home);

        Action action = (Object obj) -> {
            if (obj instanceof Light) {
                Light light = (Light)obj;
                if (light.getId().equals(event.getObjectId())) {
                    testLight = light;
                }
            }
        };

        home.execute(action);
        assertTrue(testLight.isOn());

        lightHandler.handle(event);
        assertFalse(testLight.isOn());
    }

    @Test
    public void checksIfLightIsTurnedOn() {
        SmartHome home = HomeBuilder.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "3");

        LightHandler lightHandler = new LightHandler(home);
        Action action = (Object obj) -> {
            if (obj instanceof Light) {
                Light light = (Light)obj;
                if (light.getId().equals(event.getObjectId())) {
                    testLight = light;
                }
            }
        };

        home.execute(action);
        assertFalse(testLight.isOn());

        lightHandler.handle(event);
        assertTrue(testLight.isOn());
    }
}