package ru.sbt.mipt.oop;

public class Application {

    public static void main(String... args) {
        // считываем состояние дома из файла
        HomeReader homeReader = new HomeReaderImpl();
        SmartHome smartHome = homeReader.readHome("smart-home-1.js");
        // начинаем цикл обработки событий
        EventCreatorImpl eventCreator = new EventCreatorImpl();
        AllEventsProcess allEventsProcess = new AllEventsProcess(eventCreator, new DoorEventProcessor(smartHome), new LightEventProcessor(smartHome));
        allEventsProcess.eventProcessCycle();
    }
}
