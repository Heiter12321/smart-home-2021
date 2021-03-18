package ru.sbt.mipt.oop;

import java.lang.reflect.InvocationTargetException;

public interface EventProcess {
    void processingEvent() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
