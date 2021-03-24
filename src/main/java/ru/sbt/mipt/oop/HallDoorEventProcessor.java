package ru.sbt.mipt.oop;


import java.lang.reflect.InvocationTargetException;

public class HallDoorEventProcessor implements EventProcess {
    private final SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void setLightOffAroundHome() {
        smartHome.rooms.forEach(room -> room.getLights().forEach(light -> {
            try {
                light.execute(new Action(Light.class.getDeclaredMethod("setOn", boolean.class), false));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void processingEvent() {
        setLightOffAroundHome();
    }
}
