package ru.sbt.mipt.alarm;

import ru.sbt.mipt.components.Action;
import ru.sbt.mipt.components.Actionable;

public class Alarm implements Actionable {
    private AlarmState state;
    private String code;

    public Alarm() {
        state = new DeactivatedState(this);
        code = "";
    }

    void setCode(String code) {
        this.code = code;
    }

    String getCode() {
        return code;
    }

    void changeState(AlarmState state) {
        this.state = state;
    }

    public void activate(String code) {
        state.activate(code);
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

    public void changeToAnxietyMode() {
        state.changeToAnxietyMode();
    }

    public boolean isDeactivated() {
        return state instanceof DeactivatedState;
    }


    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
