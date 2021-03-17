package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.LightSensorEventType.LIGHT_ON;

class HallDoorEventProcessorTest1 {

    @Test
    void setLightOffAroundHome() {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(smartHome);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        hallDoorEventProcessor.setLightOffAroundHome();

        assertEquals(baOut.toString(), "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='1'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='2'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='3'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='4'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='5'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='6'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='7'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='8'}\n" +
                                             "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='9'}\n");
    }
}

class HallDoorEventProcessorTest2 {

    @Test
    void setLightOffAroundHome() {
        Room room = new Room(Arrays.asList(new Light("228", true), new Light("1332", true)),
                Collections.singletonList(new Door(true, "18")),
                "hall");
        SmartHome smartHome = new SmartHome(Collections.singletonList(room));
        HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(smartHome);

        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        System.setOut(out);
        System.setErr(out);
        hallDoorEventProcessor.setLightOffAroundHome();

        assertEquals(baOut.toString(),"Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='228'}\n" +
                                            "Pretent we're sending command SensorCommand{type=LIGHT_OFF, objectId='1332'}\n");
    }
}