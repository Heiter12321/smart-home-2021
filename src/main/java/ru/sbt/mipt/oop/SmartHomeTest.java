package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeTest {

    @Test
    void execute() throws NoSuchMethodException {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        smartHome.execute(new Action(Door.class.getDeclaredMethod("setOpen", boolean.class), true));

        for (Room room : smartHome.rooms) {
            for (Door door : room.getDoors()) {
                assertTrue(door.isDoorOpen());
            }
        }
    }
}