package ru.sbt.mipt.rc;

import ru.sbt.mipt.handlers.Handler;
import ru.sbt.mipt.sensor.SensorEvent;
import ru.sbt.mipt.sensor.SensorEventType;

import java.util.Collection;

public class EnableLightsInHallCommand implements Command {
    private final Collection<Handler> handlers;

    public EnableLightsInHallCommand(Collection<Handler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void execute() {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ENABLE_HALL);
        for (Handler handler : handlers) {
            handler.handle(event);
        }
    }
}