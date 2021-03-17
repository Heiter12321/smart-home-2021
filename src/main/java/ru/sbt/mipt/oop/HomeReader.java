package ru.sbt.mipt.oop;

import java.io.IOException;

public interface HomeReader {
    SmartHome readHome(String path) throws IOException;
}
