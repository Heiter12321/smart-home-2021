package ru.sbt.mipt.oop;

import java.util.Collection;

public class EventCircle {
    private final Collection<Handler> handlers;

    EventCircle(Collection<Handler> handlers) {
        this.handlers = handlers;
    }

    private void handleSingleEvent(SensorEvent event) {
        System.out.println(event);
        for (Handler handler : handlers) {
            handler.handle(event);
        }
    }

    public void run() {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            handleSingleEvent(event);
            event = getNextSensorEvent();
        }
    }

    private SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
