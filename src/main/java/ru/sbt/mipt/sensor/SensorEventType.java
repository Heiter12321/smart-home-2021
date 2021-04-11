package ru.sbt.mipt.sensor;

public enum SensorEventType {
    LIGHT_ON, LIGHT_OFF,
    LIGHT_DISABLE_ALL, LIGHT_ENABLE_HALL, LIGHT_ENABLE_ALL,
    DOOR_OPEN, DOOR_CLOSED,
    ENTRANCE_DOOR_CLOSED,
    DOOR_LOCKED, DOOR_UNLOCKED,
    ALARM_ACTIVATE, ALARM_DEACTIVATE, ALARM_TRIGGER;
}
