package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

class DoorEventProcessorTest1 {

    @Test
    void processingEvent() {
        Collection<Light> lights = Arrays.asList(new Light("1", false), new Light("2", true));
        Collection<Door> doors = Collections.singletonList(new Door(false, "1"));
        SensorEvent event = new DoorSensorEvent(DOOR_OPEN, "3");
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor(doors);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        doorEventProcessor.processingEvent(event);

        assertEquals(baOut.toString(), "Door 3 in room bedroom was opened.\n");
    }
}

class DoorEventProcessorTest2 {

    @Test
    void processingEvent() {
        Collection<Light> lights = Arrays.asList(new Light("1", false), new Light("2", true));
        Collection<Door> doors = Collections.singletonList(new Door(false, "1"));        SensorEvent event = new DoorSensorEvent(DOOR_CLOSED, "2");
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor(doors);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        doorEventProcessor.processingEvent(event);

        assertEquals(baOut.toString(), "Door 2 in room bathroom was closed.\n");
    }
}