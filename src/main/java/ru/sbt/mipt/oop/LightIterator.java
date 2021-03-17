package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class LightIterator implements HomeElementIterator {
    private final Collection<Light> lights;
    private final Iterator<Light> iterator;

    public LightIterator(Collection<Light> lights) {
        this.lights = lights;
        this.iterator = lights.iterator();
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
