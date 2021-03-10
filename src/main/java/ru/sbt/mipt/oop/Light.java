package ru.sbt.mipt.oop;

public class Light {
    private boolean isLightOn;
    private final String id;

    public Light(String id, boolean isLightOn) {
        this.id = id;
        this.isLightOn = isLightOn;
    }

    private boolean isLightOn() {
        return isLightOn;
    }

    String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isLightOn = on;
    }
}
