package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.LightSensorEventType.LIGHT_ON;

public class LightEventProcessor extends EventProcess {
    private final SmartHome smartHome;
    private final SensorEvent event;

    public LightEventProcessor(SmartHome smartHome, SensorEvent event) {
        this.smartHome = smartHome;
        this.event = event;
    }

     public void processingEvent() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}
