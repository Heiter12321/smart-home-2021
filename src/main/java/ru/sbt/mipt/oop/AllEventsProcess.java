package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorSensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.DoorSensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.LightSensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.LightSensorEventType.LIGHT_ON;

public class AllEventsProcess {
    private final EventCreatorImpl eventCreator;
    private final SmartHome smartHome;

    public AllEventsProcess(EventCreatorImpl eventCreator, SmartHome smartHome) {
        this.eventCreator = eventCreator;
        this.smartHome = smartHome;
    }

    void eventProcessCycle() {
        SensorEvent event = eventCreator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                // событие от источника света
                LightEventProcess lightEventProcess = new LightEventProcess(smartHome, event);
                lightEventProcess.processingEvent();
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                // событие от двери
                DoorEventProcess doorEventProcess = new DoorEventProcess(smartHome, event);
                doorEventProcess.processingEvent();
            }
            event = eventCreator.getNextSensorEvent();
        }
    }
}
