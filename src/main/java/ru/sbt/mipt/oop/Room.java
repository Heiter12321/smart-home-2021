package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable, HomeElement {
    private final Collection<Light> lights;
    private final Collection<Door> doors;
    private final String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
        doors.forEach(door -> door.execute(action));
        lights.forEach(light -> light.execute(action));
    }
}
