package ru.sbt.mipt.oop;

public class Door implements Actionable, HomeElement {
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
    public void execute(Action action) {
        action.execute(this);
    }
}
