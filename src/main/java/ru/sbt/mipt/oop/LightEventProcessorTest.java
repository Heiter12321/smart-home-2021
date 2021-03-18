package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

class LightEventProcessorTest1 {
    @Test
    void processingEvent() {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        SensorEvent event = new LightSensorEvent(LIGHT_ON, "3");
        LightEventProcessor lightEventProcessor = new LightEventProcessor(smartHome, event);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        lightEventProcessor.processingEvent();

        assertEquals(baOut.toString(), "Light 3 in room bathroom was turned on.\n");
    }
}

class LightEventProcessorTest2 {
    @Test
    void processingEvent() {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        SensorEvent event = new LightSensorEvent(LIGHT_ON, "7");
        LightEventProcessor lightEventProcessor = new LightEventProcessor(smartHome, event);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        lightEventProcessor.processingEvent();

        assertEquals(baOut.toString(), "Light 7 in room hall was turned on.\n");
    }
}