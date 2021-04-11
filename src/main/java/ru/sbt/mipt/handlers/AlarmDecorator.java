package ru.sbt.mipt.handlers;

import ru.sbt.mipt.alarm.Alarm;
import ru.sbt.mipt.sensor.SensorEvent;

public class AlarmDecorator implements Handler {
    private final Alarm alarm;
    private final Handler handler;

    public AlarmDecorator(Alarm alarm, Handler handler) {
        this.alarm = alarm;
        this.handler = handler;
    }


    @Override
    public void handle(SensorEvent event) {
        if (alarm.isDeactivated()) {
            handler.handle(event);
        } else {
            alarm.changeToAnxietyMode();
        }
    }
}
