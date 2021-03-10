package ru.sbt.mipt.oop;

public class Door {
    private final String id;
    private boolean isDoorOpen;

    public Door(boolean isDoorOpen, String id) {
        this.isDoorOpen = isDoorOpen;
        this.id = id;
    }

    String getId() {
        return id;
    }

    void setOpen(boolean open) {
        isDoorOpen = open;
    }
}
