package ru.sbt.mipt.oop;

import java.lang.reflect.InvocationTargetException;

public interface Actionable {
    void execute(Action action) throws IllegalAccessException, InstantiationException, InvocationTargetException;
}
