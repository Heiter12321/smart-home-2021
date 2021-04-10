package ru.sbt.mipt;

import ru.sbt.mipt.alarm.Alarm;
import ru.sbt.mipt.handlers.*;
import ru.sbt.mipt.components.SmartHome;

import java.util.ArrayList;

public class Application{
    public static void main(String... args) {
        SmartHome smartHome = HomeReader.createHome("smart-home-1.js");
        ArrayList<Handler> handlers = new ArrayList<>();
        Alarm alarm = new Alarm();
        handlers.add(new AlarmDecorator(alarm, new LightHandler(smartHome), new SMSSender()));
        handlers.add(new AlarmDecorator(alarm, new DoorHandler(smartHome), new SMSSender()));
        handlers.add(new AlarmDecorator(alarm, new HallHandler(smartHome, new CommandSender()), new SMSSender()));
        EventCircle eventCircle = new EventCircle(handlers, new EventCreator());
        eventCircle.run();
    }
}

