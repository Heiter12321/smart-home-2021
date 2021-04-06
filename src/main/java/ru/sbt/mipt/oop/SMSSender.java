package ru.sbt.mipt.oop;

public class SMSSender {
    SmartHome smartHome;

    public SMSSender(SmartHome smartHome) {this.smartHome = smartHome;}
    public void sendSMS() {
        System.out.println("Sending SMS");
    }
}
