package ru.sbt.mipt;

import ru.sbt.mipt.components.SmartHome;

public interface HomeLoader {
    static SmartHome createHome(String fileName) {
        return null;
    }
}
