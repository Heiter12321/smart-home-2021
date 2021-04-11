package ru.sbt.mipt;

import ru.sbt.mipt.components.Door;
import ru.sbt.mipt.components.Light;
import ru.sbt.mipt.components.Room;
import ru.sbt.mipt.components.SmartHome;
import java.util.Arrays;
import java.util.Collections;

public class HomeBuilder {
    public static SmartHome createHome() {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Collections.singletonList(new Door(false, "1")),
                "kitchen");
        Room bathroom = new Room(Collections.singletonList(new Light("3", true)),
                Collections.singletonList(new Door(false, "2")),
                "bathroom");
        Room bedroom = new Room(Arrays.asList(new Light("4", false), new Light("5", false), new Light("6", false)),
                Collections.singletonList(new Door(true, "3")),
                "bedroom");
        Room hall = new Room(Arrays.asList(new Light("7", false), new Light("8", false), new Light("9", false)),
                Collections.singletonList(new Door(false, "4")),
                "hall");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));
        return smartHome;
    }

}
