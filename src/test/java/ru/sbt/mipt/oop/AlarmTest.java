package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.alarm.Alarm;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlarmTest {
    @Test
    public void activateAlarm() {
        Alarm alarm = new Alarm();
        AlarmHandler alarmHandler = new AlarmHandler(alarm);
        alarmHandler.handle(new SensorEvent(SensorEventType.ALARM_ACTIVATE, "1", "228"));
        assertFalse(alarm.isDeactivated());
    }

    @Test
    public void deactivateAlarm() {
        Alarm alarm = new Alarm();
        AlarmHandler alarmHandler = new AlarmHandler(alarm);
        alarm.activate("228");
        alarmHandler.handle(new SensorEvent(SensorEventType.ALARM_DEACTIVATE, "1", "228"));
        assertTrue(alarm.isDeactivated());
    }

    @Test
    public void checksIfAlarmIsDeactivated() {
        Alarm alarm = new Alarm();
        alarm.activate("228");
        assertFalse(alarm.isDeactivated());
    }

    @Test
    public void checksIfAlarmIsDeactivatedWithWrongCode() {
        Alarm alarm = new Alarm();
        alarm.activate("228");
        alarm.deactivate("1499");
        assertFalse(alarm.isDeactivated());
    }

    @Test
    public void checksIfAlarmIsDeactivated() {
        Alarm alarm = new Alarm();
        alarm.activate("228");
        alarm.deactivate("228");
        assertTrue(alarm.isDeactivated());
    }
}
