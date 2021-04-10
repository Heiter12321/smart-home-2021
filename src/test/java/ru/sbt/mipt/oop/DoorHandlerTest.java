package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoorHandlerTest {
    private Door testDoor;
    @Test
    public void checksIfDoorIsClosed() {
        HomeCreator homeCreator = new HomeCreator();
        SmartHome home = homeCreator.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        DoorHandler doorHandler = new DoorHandler(home);
        Action action = (Object obj) -> {
            if (obj instanceof Door) {
                Door door = (Door)obj;
                if (door.getId().equals(event.getObjectId())) {
                    testDoor = door;
                }
            }
        };

        home.execute(action);
        assertTrue(testDoor.isOpen());

        doorHandler.handle(event);
        assertFalse(testDoor.isOpen());
    }

    @Test
    public void checksIfDoorIsOpen() {
        HomeCreator homeCreator = new HomeCreator();
        SmartHome home = homeCreator.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "3");

        DoorHandler doorHandler = new DoorHandler(home);
        Action action = (Object obj) -> {
            if (obj instanceof Door) {
                Door door = (Door)obj;
                if (door.getId().equals(event.getObjectId())) {
                    testDoor = door;
                }
            }
        };

        home.execute(action);
        assertFalse(testDoor.isOpen());

        doorHandler.handle(event);
        assertTrue(testDoor.isOpen());
    }
}