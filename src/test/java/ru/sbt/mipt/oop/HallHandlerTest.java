package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HallHandlerTest {
    private Door testDoor;
    private ArrayList<Boolean> expectedLightStates = new ArrayList<Boolean>();
    private ArrayList<Boolean> actualLightStates = new ArrayList<Boolean>();

    @Test
    public void checksIfDoorIsClosed() {
        HomeCreator homeCreator = new HomeCreator();
        SmartHome home = homeCreator.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        HallHandler hallHandler = new HallHandler(home);
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

        hallHandler.handle(event);
        assertFalse(testDoor.isOpen());
    }

    @Test
    public void handle() {
        HomeCreator homeCreator = new HomeCreator();
        SmartHome home = homeCreator.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        HallHandler hallHandler = new HallHandler(home);
        hallHandler.handle(event);
        Action action = (Object obj) -> {
            if (obj instanceof Light) {
                Light light = (Light)obj;
                expectedLightStates.add(false);
                actualLightStates.add(light.isOn());
            }
        };

        home.execute(action);
        assertArrayEquals(expectedLightStates.toArray(new Boolean[0]), actualLightStates.toArray(new Boolean[0]));
    }
}