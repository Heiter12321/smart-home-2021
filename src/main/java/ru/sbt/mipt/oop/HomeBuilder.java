package ru.sbt.mipt.oop;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class HomeBuilder {

    public static void main(String[] args) {
        SmartHome smartHome = new SmartHome(createFourRooms());
        HomePrinter homePrinter = new HomePrinter(smartHome);
        homePrinter.printRoom();
    }

    public static Collection<Room> createFourRooms() {
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
        return Arrays.asList(kitchen, bathroom, bedroom, hall);
    }
}
