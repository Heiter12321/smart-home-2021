package ru.sbt.mipt;

import org.junit.Test;
import ru.sbt.mipt.components.Action;
import ru.sbt.mipt.components.Door;
import ru.sbt.mipt.components.Light;
import ru.sbt.mipt.components.SmartHome;
import ru.sbt.mipt.handlers.HallHandler;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HallHandlerTest {
    private Door testDoor;
    private ArrayList<Boolean> expectedLightStates = new ArrayList<>();
    private ArrayList<Boolean> actualLightStates = new ArrayList<>();

    @Test
    public void checksIfDoorIsClosed() {
        SmartHome home = HomeBuilder.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        HallHandler hallHandler = new HallHandler(home, new CommandSender());
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
        SmartHome home = HomeBuilder.createHome();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        HallHandler hallHandler = new HallHandler(home, new CommandSender());
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