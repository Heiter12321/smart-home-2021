package ru.sbt.mipt.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.handlers.Handler;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

import java.util.Map;

public class AdapterHandler implements EventHandler {
    private final Handler handler;
    private final Map<String, SensorEventType> factory;

    public AdapterHandler(Handler handler, Map<String, SensorEventType> factory) {
        this.handler = handler;
        this.factory = factory;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        if (factory.containsKey(event.getEventType())) {
            SensorEvent sensorEvent = new SensorEvent(factory.get(event.getEventType()), event.getObjectId());
            handler.handle(sensorEvent);
        }
    }
}
