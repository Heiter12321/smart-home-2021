package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import org.junit.Test;
import ru.sbt.mipt.HomeBuilder;
import ru.sbt.mipt.adapter.AdapterHandler;
import ru.sbt.mipt.handlers.DoorHandler;
import ru.sbt.mipt.components.Action;
import ru.sbt.mipt.components.Door;
import ru.sbt.mipt.components.SmartHome;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdapterTest {
    private Door testDoor;

    @Test
    public void testOpensDoorWhenOpenEventReceived() {
        SmartHome home = HomeBuilder.createHome();
        CCSensorEvent event = new CCSensorEvent("DoorIsOpen", "2");

        DoorHandler doorHandler = new DoorHandler(home);
        AdapterHandler adapterHandler = new AdapterHandler(doorHandler);
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

        adapterHandler.handleEvent(event);
        assertTrue(testDoor.isOpen());
    }

    @Test
    public void testClosesDoorWhenCloseEventReceived() {
        SmartHome home = HomeBuilder.createHome();
        CCSensorEvent event = new CCSensorEvent("DoorIsClosed", "3");

        DoorHandler doorHandler = new DoorHandler(home);
        AdapterHandler adapterHandler = new AdapterHandler(doorHandler);
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

        adapterHandler.handleEvent(event);
        assertFalse(testDoor.isOpen());
    }
}
