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

            DoorEventProcessor doorEventProcessor = new DoorEventProcessor(smartHome, event);
            doorEventProcessor.processingEvent();

            LightEventProcessor lightEventProcessor = new LightEventProcessor(smartHome, event);
            lightEventProcessor.processingEvent();

            event = eventCreator.getNextSensorEvent();
        }
    }
}
