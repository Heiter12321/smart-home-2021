package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class HallDoorEventProcessorTest1 {

    @Test
    void setLightOffAroundHome() {
        Collection<Light> lights = Arrays.asList(new Light("1", false), new Light("2", true));
        Collection<Door> doors = Collections.singletonList(new Door(false, "1"));
        HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(lights);
        hallDoorEventProcessor.setLightOffAroundHome();

        for (Light light : lights) {
            assertFalse(light.isLightOn());
        }
    }
}
