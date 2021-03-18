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

            EventDistributor eventDistributor = new EventDistributor();
            EventProcess eventProcessor =  eventDistributor.getNeededEventProcessor(smartHome, event);
            eventProcessor.processingEvent();

            event = eventCreator.getNextSensorEvent();
        }
    }
}
