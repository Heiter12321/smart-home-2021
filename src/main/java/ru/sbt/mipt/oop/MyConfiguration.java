package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class MyConfiguration {
    @Bean
    SmartHome smartHome() throws IOException {
        HomeReader homeReader = new HomeReaderImpl();
        return homeReader.readHome("smart-home-1.js");
    }

    @Bean
    SensorEventsManager sensorEventsManager() {
        return new SensorEventsManager();
    }
}
