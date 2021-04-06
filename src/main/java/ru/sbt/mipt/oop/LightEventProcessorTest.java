package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

class LightEventProcessorTest1 {
    @Test
    void processingEvent() {
        Collection<Light> lights = Arrays.asList(new Light("1", false), new Light("2", true));
        Collection<Door> doors = Collections.singletonList(new Door(false, "1"));        SensorEvent event = new LightSensorEvent(LIGHT_ON, "3");
        LightEventProcessor lightEventProcessor = new LightEventProcessor(lights);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        lightEventProcessor.processingEvent(event);

        assertEquals(baOut.toString(), "Light 3 was turned on.\n");
    }
}

class LightEventProcessorTest2 {
    @Test
    void processingEvent() {
        Collection<Light> lights = Arrays.asList(new Light("1", false), new Light("2", true));
        Collection<Door> doors = Collections.singletonList(new Door(false, "1"));        SensorEvent event = new LightSensorEvent(LIGHT_ON, "7");
        LightEventProcessor lightEventProcessor = new LightEventProcessor(lights);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        lightEventProcessor.processingEvent(event);

        assertEquals(baOut.toString(), "Light 7 was turned on.\n");
    }
}