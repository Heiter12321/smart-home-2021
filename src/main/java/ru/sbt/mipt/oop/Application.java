package ru.sbt.mipt.oop;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Application {

    public static void main(String... args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // считываем состояние дома из файла
        HomeReader homeReader = new HomeReaderImpl();
        SmartHome smartHome = homeReader.readHome("smart-home-1.js");
        // начинаем цикл обработки событий
        EventCreatorImpl eventCreator = new EventCreatorImpl();
        AllEventsProcess allEventsProcess = new AllEventsProcess(eventCreator, smartHome);
        allEventsProcess.eventProcessCycle();
    }
}
