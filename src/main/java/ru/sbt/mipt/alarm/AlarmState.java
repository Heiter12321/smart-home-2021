package ru.sbt.mipt.alarm;

public interface AlarmState {
    void activate(String code);
    void deactivate(String code);
    void changeToAnxietyMode();
}
