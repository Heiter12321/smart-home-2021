package ru.sbt.mipt.oop;

import java.util.ArrayList;

public class Application {
    public static void main(String... args) {
        SmartHome smartHome = HomeCreator.createHome("smart-home-1.js");
        ArrayList<Handler> handlers = new ArrayList<Handler>();
        handlers.add(new LightHandler(smartHome));
        handlers.add(new DoorHandler(smartHome));
        handlers.add(new HallHandler(smartHome, new CommandSender()));
        EventCircle eventCircle = new EventCircle(handlers, new EventCreator());
        eventCircle.run();
    }
}
