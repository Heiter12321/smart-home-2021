package ru.sbt.mipt.oop;

public class AllEventsProcess {
    private final EventCreator eventCreator;
    private final SmartHome smartHome;

    public AllEventsProcess(EventCreatorImpl eventCreator, SmartHome smartHome) {
        this.eventCreator = eventCreator;
        this.smartHome = smartHome;
    }

    void eventProcessCycle() {
        SensorEvent event = eventCreator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);

            new DoorEventProcessor(smartHome, event).processingEvent();

            new LightEventProcessor(smartHome, event).processingEvent();

            event = eventCreator.getNextSensorEvent();
        }
    }
}
