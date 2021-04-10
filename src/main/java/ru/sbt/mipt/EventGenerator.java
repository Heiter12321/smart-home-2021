package ru.sbt.mipt;

import ru.sbt.mipt.sensor.SensorEvent;

public interface EventGenerator {
    SensorEvent getNextSensorEvent();
}

