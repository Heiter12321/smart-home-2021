package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeTest {

    @Test
    void execute() {
        SmartHome smartHome = new SmartHome(HomeBuilder.createFourRooms());
        smartHome.execute((Action) new Door(true, "7"));
    }
}