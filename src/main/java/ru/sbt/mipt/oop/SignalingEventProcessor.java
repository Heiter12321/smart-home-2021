package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SignalingEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SignalingEventType.ALARM_DEACTIVATE;

public class SignalingEventProcessor extends EventProcess {
    public EventProcess eventProcess;

    public SignalingEventProcessor(EventProcess eventProcess) {
        this.eventProcess = eventProcess;
    }

    public void processingEvent(SmartHome smartHome, Event event) {
        if (event.getType() == ALARM_ACTIVATE) {
            smartHome.signaling.activate(ALARM_ACTIVATE.code);
        } else if (event.getType() == ALARM_DEACTIVATE) {
            smartHome.signaling.activate(ALARM_DEACTIVATE.code);
        }
    }
}
