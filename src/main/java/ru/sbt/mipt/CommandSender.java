package ru.sbt.mipt;

import ru.sbt.mipt.sensor.SensorCommand;

public class CommandSender {
    public void sendCommand(SensorCommand command) {
        System.out.println(command);
    }
}
