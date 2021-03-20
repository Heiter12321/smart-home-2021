package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class RoomIterator implements HomeElementIterator {
    private final Iterator<Room> iterator;

    public RoomIterator(Collection<Room> rooms) {
        this.iterator = rooms.iterator();
    }

    @Override
    public Room getNext() {
        if (hasMore()) {
            return iterator.next();
        }
        return null;
    }

    @Override
    public boolean hasMore() {
        return iterator.hasNext();
    }
}
