package ru.sbt.mipt.oop;

import java.util.ArrayList;

public class Application {

    public static void main(String... args) throws Exception {
        SmartHome smartHome = HomeReader.createHome("smart-home-1.js");
        ArrayList<Handler> handlers = new ArrayList<>();
        handlers.add(new LightHandler(smartHome));
        handlers.add(new DoorHandler(smartHome));
        handlers.add(new HallHandler(smartHome));
        EventCircle eventCircle = new EventCircle(handlers);
        eventCircle.run();
    }
}
