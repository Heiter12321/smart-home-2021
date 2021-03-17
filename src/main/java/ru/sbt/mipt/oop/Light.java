package ru.sbt.mipt.oop;

public class Light implements HomeElement {
    private boolean isLightOn;
    private final String id;

    public Light(String id, boolean isLightOn) {
        this.id = id;
        this.isLightOn = isLightOn;
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isLightOn = on;
    }
}
