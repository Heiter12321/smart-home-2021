package ru.sbt.mipt.oop;


import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public class Room implements Actionable {
    private final Collection<Light> lights;
    private final Collection<Door> doors;
    private final String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        DoorIterator doorIterator = new DoorIterator(doors);
        LightIterator lightIterator = new LightIterator(lights);
        while (doorIterator.hasMore()) {
            doorIterator.getNext().execute(action);
        }
        while (lightIterator.hasMore()) {
            lightIterator.getNext().execute(action);
        }
    }
}
