package ru.sbt.mipt.oop;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() { rooms = new ArrayList<>(); }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void execute(Action action) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        RoomIterator iterator = new RoomIterator(rooms);
        while (iterator.hasMore()) {
            iterator.getNext().execute(action);
        }
    }
}
