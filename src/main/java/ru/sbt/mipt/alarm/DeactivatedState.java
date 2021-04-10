package ru.sbt.mipt.alarm;

public class DeactivatedState implements AlarmState {
    private final Alarm alarm;
    DeactivatedState(Alarm alarm){
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        alarm.changeState(new ActivatedState(alarm));
        alarm.setCode(code);
    }

    @Override
    public void deactivate(String code) {
    }

    @Override
    public void changeToAnxietyMode() {
        alarm.changeState(new AnxietyState(alarm));
    }

}
