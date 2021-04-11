package ru.sbt.mipt;

import org.junit.Test;
import ru.sbt.mipt.components.Action;
import ru.sbt.mipt.components.Door;
import ru.sbt.mipt.components.SmartHome;
import ru.sbt.mipt.handlers.DoorHandler;
import ru.sbt.mipt.handlers.EntranceDoorCloser;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoorHandlerTest {
    private Door testDoor;
    @Test
    public void checksIfDoorIsClosed() {
        SmartHome home = HomeBuilder.createHome();
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
        SmartHome home = HomeBuilder.createHome();
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

    @Test
    public void checksIfDoorIsLocked() {
        SmartHome home = HomeBuilder.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_LOCKED, "3");

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
        assertFalse(testDoor.isLocked());

        doorHandler.handle(event);
        assertTrue(testDoor.isLocked());
    }

    @Test
    public void testClosesEntranceDoorWhenEventReceived(){
        SmartHome home = HomeBuilder.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.ENTRANCE_DOOR_CLOSED, "3");

        EntranceDoorCloser entranceHandler = new EntranceDoorCloser(home);
        Action action = (Object obj) -> {
            if (obj instanceof Door) {
                Door door = (Door)obj;
                if (door.isEntrance()) {
                    testDoor = door;
                }
            }
        };

        home.execute(action);
        assertTrue(testDoor.isOpen());

        entranceHandler.handle(event);
        assertFalse(testDoor.isOpen());
    }
}