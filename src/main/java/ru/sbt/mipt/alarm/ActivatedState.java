package ru.sbt.mipt.alarm;

public class ActivatedState implements AlarmState{
    private final Alarm alarm;

    ActivatedState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {
        if (code.equals(alarm.getCode())) {
            alarm.changeState(new DeactivatedState(alarm));
        } else {
            alarm.changeState(new AnxietyState(alarm));
        }

    }

    @Override
    public void changeToAnxietyMode() {
        alarm.changeState(new AnxietyState(alarm));
    }

}
