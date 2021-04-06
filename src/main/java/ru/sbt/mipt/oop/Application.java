package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        HomeReader homeReader = new HomeReaderImpl();
        SmartHome smartHome = homeReader.readHome("smart-home-1.js");
        // начинаем цикл обработки событий
    }
}
