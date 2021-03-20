package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class LightIterator implements HomeElementIterator {
    private final Iterator<Light> iterator;

    public LightIterator(Collection<Light> lights) {
        this.iterator = lights.iterator();
    }

    @Override
    public Light getNext() {
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
