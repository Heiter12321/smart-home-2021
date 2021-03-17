package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.DoorSensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.DoorSensorEventType.DOOR_OPEN;

class DoorEventProcessorTest1 {

    @Test
    void processingEvent() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        SensorEvent event = new DoorSensorEvent(DOOR_OPEN, "3");
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor(smartHome, event);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        doorEventProcessor.processingEvent();

        assertEquals(baOut.toString(), "Door 3 in room bedroom was opened.\n");
    }
}

class DoorEventProcessorTest2 {

    @Test
    void processingEvent() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        SensorEvent event = new DoorSensorEvent(DOOR_CLOSED, "2");
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor(smartHome, event);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        doorEventProcessor.processingEvent();

        assertEquals(baOut.toString(), "Door 2 in room bathroom was closed.\n");
    }
}