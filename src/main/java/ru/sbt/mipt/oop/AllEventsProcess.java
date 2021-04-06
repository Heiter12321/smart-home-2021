package ru.sbt.mipt.oop;

public class AllEventsProcess {
    private final SmartHome smartHome;
    private final EventCreator eventCreator;
    private final DoorEventProcessor doorEventProcessor;
    private final LightEventProcessor lightEventProcessor;
    private final SignalingEventProcessor signalingEventProcessor;


    public AllEventsProcess(SmartHome smartHome, EventCreatorImpl eventCreator, DoorEventProcessor doorEventProcessor, LightEventProcessor lightEventProcessor, SignalingEventProcessor signalingEventProcessor) {
        this.smartHome = smartHome;
        this.eventCreator = eventCreator;
        this.doorEventProcessor = doorEventProcessor;
        this.lightEventProcessor = lightEventProcessor;
        this.signalingEventProcessor = signalingEventProcessor;
    }

    void eventProcessCycle() {
        Event event = eventCreator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);

            doorEventProcessor.processingEvent(smartHome, event);
            lightEventProcessor.processingEvent(smartHome, event);
            signalingEventProcessor.processingEvent(smartHome, event);

            event = eventCreator.getNextSensorEvent();
        }
    }
}
