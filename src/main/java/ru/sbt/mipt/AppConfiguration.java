package ru.sbt.mipt;

import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.adapter.AdapterHandler;
import ru.sbt.mipt.alarm.Alarm;
import ru.sbt.mipt.components.SmartHome;
import ru.sbt.mipt.handlers.*;
import ru.sbt.mipt.sensor.SensorEventType;

import java.util.Collection;
import java.util.HashMap;

@Configuration
public class AppConfiguration {

    @Bean
    public HashMap<String, SensorEventType> createFactory() {
        HashMap<String, SensorEventType> factory = new HashMap<>();
        factory.put("LightIsOn", SensorEventType.LIGHT_ON);
        factory.put("LightIsOff", SensorEventType.LIGHT_OFF);
        factory.put("DoorIsOpen", SensorEventType.DOOR_OPEN);
        factory.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        factory.put("DoorIsLocked", SensorEventType.DOOR_LOCKED);
        factory.put("DoorIsUnlocked", SensorEventType.DOOR_UNLOCKED);
        return factory;
    }

    @Bean
    public Alarm alarm() {
        return new Alarm();
    }

    @Bean
    public SMSSender sender() {
        return new SMSSender();
    }

    @Bean
    public SmartHome createHome() {
        return HomeReader.createHome("smart-home-1.js");
    }

    @Bean
    public EventHandler lightHandler(SmartHome home, Alarm alarm, SMSSender sender, HashMap<String, SensorEventType> factory) {
        Handler handler = new AlarmDecorator(alarm, new LightHandler(home), sender);
        return new AdapterHandler(handler, factory);
    }

    @Bean
    public EventHandler doorHandler(SmartHome home, Alarm alarm, SMSSender sender, HashMap<String, SensorEventType> factory) {
        Handler handler = new AlarmDecorator(alarm, new DoorHandler(home), sender);
        return new AdapterHandler(handler, factory);
    }

    @Bean
    public EventHandler doorLockHandler(SmartHome home, Alarm alarm, SMSSender sender, HashMap<String, SensorEventType> factory) {
        Handler handler = new AlarmDecorator(alarm, new DoorLockHandler(home), sender);
        return new AdapterHandler(handler, factory);
    }

    @Bean
    public EventHandler hallHandler(SmartHome home, Alarm alarm, SMSSender sender, HashMap<String, SensorEventType> factory) {
        Handler handler = new AlarmDecorator(alarm, new HallHandler(home, new CommandSender()), sender);
        return new AdapterHandler(handler, factory);
    }

    @Bean
    public SensorEventsManager eventManager(Collection<EventHandler> handlers) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();

        for (EventHandler handler : handlers) {
            sensorEventsManager.registerEventHandler(handler);
        }

        return sensorEventsManager;
    }

}
