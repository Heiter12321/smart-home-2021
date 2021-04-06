package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;

import java.util.Locale;

public class EventAdaptor implements com.coolcompany.smarthome.events.EventHandler {
    private final EventProcess eventProcess;
    private final SmartHome smartHome;

    public EventAdaptor(EventProcess eventProcess, SmartHome smartHome) {
        this.eventProcess = eventProcess;
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(CCSensorEvent ccSensorEvent) {
        SensorEventType sensorEventType = getEventType(ccSensorEvent.getEventType());
        SensorEvent sensorEvent = new SensorEvent(sensorEventType, ccSensorEvent.getObjectId());
        eventProcess.processingEvent(smartHome, sensorEvent);
    }

    private static SensorEventType getEventType(String ccEventType) {
        return SensorEventType.valueOf(ccEventType.toUpperCase(Locale.ROOT).replace("IS", "_"));
    }
}
