package ru.sbt.mipt.oop;

import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor extends EventProcess {
    private final Collection<Light> lights;

    public LightEventProcessor(Collection<Light> lights) {
        this.lights = lights;
    }

     public void processingEvent(SmartHome smartHome, Event event) {
         lights.forEach(light -> {
             if (light.getId().equals(event.getObjectId())) {
                 if (smartHome.signaling.state.getClass().isInstance(ActivateState.class)) {
                     smartHome.signaling.changeState(new AlarmState(smartHome.signaling));
                     new SMSSender(smartHome).sendSMS();
                     return;
                 }
                 if (smartHome.signaling.state.getClass().isInstance(AlarmState.class)) {
                     return;
                 }
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
