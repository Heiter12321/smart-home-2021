package ru.sbt.mipt;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.alarm.Alarm;
import ru.sbt.mipt.handlers.*;
import ru.sbt.mipt.components.*;
import ru.sbt.mipt.rc.*;
import ru.sbt.mipt.rc.RemoteController;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoteControlTest {
    private RemoteController remoteController;
    private SmartHome home;
    private String id;
    private Alarm alarm;
    private Room hall;

    private void init() {
        home = HomeBuilder.createHome();
        alarm = new Alarm();

        ArrayList<Handler> handlers = new ArrayList<>();
        handlers.add(new AlarmHandler(alarm));
        handlers.add(new HallLightEnabler(home));
        handlers.add(new EntranceDoorCloser(home));
        handlers.add(new LightsDisabler(home));
        handlers.add(new LightsEnabler(home));

        HashMap<String, Command> buttonToCommand = new HashMap<>();
        buttonToCommand.put("1", new ActivateAlarmCommand(handlers));
        buttonToCommand.put("2", new TriggerAlarmCommand(handlers));
        buttonToCommand.put("3", new EnableLightsInHallCommand(handlers));
        buttonToCommand.put("4", new CloseEntranceDoorCommand(handlers));
        buttonToCommand.put("A", new AllLightsDisableCommand(handlers));
        buttonToCommand.put("B", new AllLightsEnableCommand(handlers));

        id = "1";
        remoteController = new RemoteController(buttonToCommand, id);
    }

    @Test
    void testActivatesAlarmWhenButtonPressed() {
        init();
        assertTrue(alarm.isDeactivated());

        remoteController.onButtonPressed("1", id);
        assertFalse(alarm.isDeactivated());
    }

    @Test
    void testTriggersAlarmWhenButtonPressed() {
        init();
        assertTrue(alarm.isDeactivated());

        remoteController.onButtonPressed("2", id);
        assertFalse(alarm.isDeactivated());
    }

    @Test
    void testEnablesLightsInHallWhenButtonPressed() {
        init();

        remoteController.onButtonPressed("3", id);
        Action action = (Object obj) -> {
            if (obj instanceof Room) {
                Room room = (Room)obj;
                if (room.getName().equals("hall")) {
                    hall = room;
                }
            }
        };

        home.execute(action);

        Collection<Light> lights = new ArrayList<>();
        try {
            Field lightsField = hall.getClass().getDeclaredField("lights");
            lightsField.setAccessible(true);
            lights = (Collection<Light>) lightsField.get(hall);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ArrayList<Boolean> actualLightStates = new ArrayList<>();
        ArrayList<Boolean> expectedLightStates = new ArrayList<>();

        for (Light light : lights) {
            actualLightStates.add(light.isOn());
            expectedLightStates.add(true);
        }
        assertArrayEquals(expectedLightStates.toArray(new Boolean[0]), actualLightStates.toArray(new Boolean[0]));
    }
}
