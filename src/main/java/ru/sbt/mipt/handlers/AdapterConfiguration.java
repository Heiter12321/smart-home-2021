package ru.sbt.mipt.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.sensor.SensorEventType;

import java.util.Locale;

@Configuration
public class AdapterConfiguration {
    @Bean(name = "EventType")
    public static SensorEventType getEventType(String ccEventType) {
        return SensorEventType.valueOf(ccEventType.toUpperCase(Locale.ROOT).replace("IS", "_"));
    }
}
