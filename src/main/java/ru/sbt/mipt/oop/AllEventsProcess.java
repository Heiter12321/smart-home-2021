package ru.sbt.mipt.oop;

public class AllEventsProcess {
    private final EventCreator eventCreator;
    private final DoorEventProcessor doorEventProcessor;
    private final LightEventProcessor lightEventProcessor;

    public AllEventsProcess(EventCreatorImpl eventCreator, DoorEventProcessor doorEventProcessor, LightEventProcessor lightEventProcessor) {
        this.eventCreator = eventCreator;
        this.doorEventProcessor = doorEventProcessor;
        this.lightEventProcessor = lightEventProcessor;
    }

    void eventProcessCycle() {
        SensorEvent event = eventCreator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);

            doorEventProcessor.processingEvent(event);
            lightEventProcessor.processingEvent(event);

            event = eventCreator.getNextSensorEvent();
        }
    }
}
