package ru.sbt.mipt.oop;


import java.lang.reflect.InvocationTargetException;

public class HallDoorEventProcessor implements EventProcess {
    private final SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void setLightOffAroundHome() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        smartHome.execute(new Action(Light.class.getDeclaredMethod("setOn", boolean.class), false));
    }

    @Override
    public void processingEvent() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        setLightOffAroundHome();
    }
}
