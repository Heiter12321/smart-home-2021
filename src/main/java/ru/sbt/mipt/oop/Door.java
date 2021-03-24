package ru.sbt.mipt.oop;

import java.lang.reflect.InvocationTargetException;

public class Door implements Actionable {
    private final String id;
    private boolean isDoorOpen;

    public Door(boolean isDoorOpen, String id) {
        this.isDoorOpen = isDoorOpen;
        this.id = id;
    }

    String getId() {
        return id;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    void setOpen(boolean open) {
        isDoorOpen = open;
    }

    @Override
    public void execute(Action action) throws IllegalAccessException, InvocationTargetException {
        try {
            Door.class.getDeclaredMethod(action.getMethod().getName(), boolean.class);
            action.getMethod().invoke(this, action.getParams());
        } catch (NoSuchMethodException ignored) {
        }
    }
}
