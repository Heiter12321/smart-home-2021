package ru.sbt.mipt.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.handlers.AdapterConfiguration;
import ru.sbt.mipt.handlers.Handler;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

public class AdapterHandler implements EventHandler {
    private final Handler handler;


    public AdapterHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEventType sensorEventType = AdapterConfiguration.getEventType(event.getEventType());
        SensorEvent sensorEvent = new SensorEvent(sensorEventType, event.getObjectId());
        handler.handle(sensorEvent);
    }
}
