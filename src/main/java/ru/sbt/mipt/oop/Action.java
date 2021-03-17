package ru.sbt.mipt.oop;

import java.lang.reflect.Method;

public class Action {
    private final Method method;
    private final Object params;

    public Action(Method method, boolean params) {
        this.method = method;
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public Object getParams() {
        return params;
    }
}
