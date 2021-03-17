package ru.sbt.mipt.oop;

import java.util.Collection;

public class IteratorCreator {
    public IteratorCreator() {
    }

    public HomeElementIterator getIterator(Action action, Collection<Light> lights, Collection<Door> doors) {
        if (action.getMethod().getDeclaringClass() == Light.class) {
            return new LightIterator(lights);
        } else {
            return new DoorIterator(doors);
        }
    }
}
