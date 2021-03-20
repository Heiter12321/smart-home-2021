package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventProcessor implements EventProcess {
    private final SmartHome smartHome;
    private final SensorEvent event;

    public LightEventProcessor(SmartHome smartHome, SensorEvent event) {
        this.smartHome = smartHome;
        this.event = event;
    }

     public void processingEvent() {
         if (!(event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)) {
             return;
         }

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
