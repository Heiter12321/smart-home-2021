package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Light light;

    @Test
    void execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());

        int i = 0;
        for (Room room : smartHome.rooms) {
            room.execute(new Action(Light.class.getDeclaredMethod("setOn", boolean.class), i % 2 == 0));
            ++i;
        }

        i = 0;

        for (Room room : smartHome.rooms) {
            for (Light light : room.getLights()) {
                assertEquals(i % 2 == 0, light.isLightOn());
            }
            ++i;
        }

    }
}