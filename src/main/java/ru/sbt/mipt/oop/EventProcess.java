package ru.sbt.mipt.oop;

import java.lang.reflect.InvocationTargetException;

public interface EventProcess {
    void processingEvent(SensorEvent event) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
