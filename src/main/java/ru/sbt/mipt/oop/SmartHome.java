package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable, HomeElement {
    private Collection<Room> rooms;
    Signaling signaling;

    public SmartHome() { rooms = new ArrayList<>(); }

    public SmartHome(Collection<Room> rooms, Signaling signaling) {
        this.rooms = rooms;
        this.signaling = signaling;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
        rooms.forEach(room -> room.execute(action));
    }
}
