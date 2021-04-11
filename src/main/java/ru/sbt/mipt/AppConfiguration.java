package ru.sbt.mipt;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.adapter.AdapterHandler;
import ru.sbt.mipt.alarm.Alarm;
import ru.sbt.mipt.handlers.*;
import ru.sbt.mipt.components.SmartHome;
import ru.sbt.mipt.sensor.SensorEventType;

import java.util.Collection;
import java.util.HashMap;

@Configuration
public class AppConfiguration {
    @Bean
    public Alarm createAlarm() {
        return new Alarm();
    }

    @Bean
    public SmartHome createHome () {
        return HomeReader.createHome("smart-home-1.js");
    }

    @Bean
    public AdapterHandler lightHandler(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new LightHandler(home)));
    }

    @Bean
    public AdapterHandler doorHandler(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new DoorHandler(home)));
    }

    @Bean
    public AdapterHandler doorLockHandler(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new DoorLockHandler(home)));
    }

    @Bean
    public AdapterHandler hallHandler(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new HallHandler(home, new CommandSender())));
    }

    @Bean
    public AdapterHandler alarmHandler(Alarm alarm) {
        return new AdapterHandler(new AlarmHandler(alarm));
    }

    @Bean
    public AdapterHandler hallLightHandler(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new HallLightEnabler(home)));
    }

    @Bean
    public AdapterHandler entranceDoorCloser(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new EntranceDoorCloser(home)));
    }

    @Bean
    public AdapterHandler lightsDisabler(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new LightsDisabler(home)));
    }

    @Bean
    public AdapterHandler lightsEnabler(SmartHome home, Alarm alarm) {
        return new AdapterHandler(new AlarmDecorator(alarm, new LightsEnabler(home)));
    }

    @Bean
    public SensorEventsManager createEventManager(Collection<AdapterHandler> handlers) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();

        for (AdapterHandler handler : handlers) {
            sensorEventsManager.registerEventHandler(handler);
        }

        return sensorEventsManager;
    }


}
