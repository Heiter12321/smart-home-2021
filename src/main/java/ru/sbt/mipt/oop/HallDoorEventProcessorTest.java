package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.LightSensorEventType.LIGHT_ON;

class HallDoorEventProcessorTest1 {

    @Test
    void setLightOffAroundHome() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(smartHome);
        hallDoorEventProcessor.setLightOffAroundHome();

        for (Room room : smartHome.rooms) {
            for (Light light : room.getLights()) {
                assertFalse(light.isLightOn());
            }
        }
    }
}

class HallDoorEventProcessorTest2 {

    @Test
    void setLightOffAroundHome() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Room room = new Room(Arrays.asList(new Light("228", true), new Light("1332", true)),
                Collections.singletonList(new Door(true, "18")),
                "hall");
        SmartHome smartHome = new SmartHome(Collections.singletonList(room));
        HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(smartHome);
        hallDoorEventProcessor.setLightOffAroundHome();
        for (Room room1 : smartHome.rooms) {
            for (Light light : room1.getLights()) {
                assertFalse(light.isLightOn());
            }
        }
    }
}