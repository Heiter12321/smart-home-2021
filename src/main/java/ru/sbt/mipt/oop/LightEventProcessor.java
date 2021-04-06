package ru.sbt.mipt.oop;

import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcess {
    private final Collection<Light> lights;

    public LightEventProcessor(Collection<Light> lights) {
        this.lights = lights;
    }

     public void processingEvent(SensorEvent event) {
         lights.forEach(light -> {
             if (light.getId().equals(event.getObjectId())) {
                 if (event.getType() == LIGHT_ON) {
                     light.setOn(true);
                     System.out.println("Light " + light.getId() + " was turned on.");
                 } else {
                     light.setOn(false);
                     System.out.println("Light " + light.getId() + " was turned off.");
                 }
             }
         });
    }
}
