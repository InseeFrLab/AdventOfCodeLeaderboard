package fr.insee.aventcalendar.config;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomDateFormat {

    @Value("${date.format:dd/MM/yyyy HH:mm:ss}")
    private String dateFormat;

    @Value("${date.zoneId:Europe/Paris}")
    private String zoneId;

    @Bean
    public ZoneId getZoneId() {
    	return ZoneId.of(zoneId);
    }

    @Bean
    public DateTimeFormatter getDateFormatter() {
    	return DateTimeFormatter.ofPattern(dateFormat);
    }
}
