package ru.sbt.mipt.oop;

import java.lang.reflect.InvocationTargetException;

public class AllEventsProcess {
    private final EventCreator eventCreator;
    private final SmartHome smartHome;

    public AllEventsProcess(EventCreatorImpl eventCreator, SmartHome smartHome) {
        this.eventCreator = eventCreator;
        this.smartHome = smartHome;
    }

    void eventProcessCycle() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        SensorEvent event = eventCreator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);

            EventProcess eventProcess = new EventProcess();
            eventProcess.processingEvent(smartHome, event);

            event = eventCreator.getNextSensorEvent();
        }
    }
}
