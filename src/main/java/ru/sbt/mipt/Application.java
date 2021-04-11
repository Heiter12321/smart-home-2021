package ru.sbt.mipt;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.sbt.mipt.rc.RemoteControlConfiguration;


public class Application{

    public static void main(String... args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class, RemoteControlConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
    }
}

