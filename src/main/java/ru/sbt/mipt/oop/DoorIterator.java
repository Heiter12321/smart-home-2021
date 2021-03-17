package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class DoorIterator implements HomeElementIterator {
    private final Collection<Door> doors;
    private final Iterator<Door> iterator;

    public DoorIterator(Collection<Door> doors) {
        this.doors = doors;
        this.iterator = doors.iterator();
    }

    @Override
    public HomeElement getNext() {
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
