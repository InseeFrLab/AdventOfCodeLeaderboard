package fr.insee.aventcalendar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
public class CustomDateFormat {

    @Value("${date.format}")
    private String dateFormat;

    @Value("${date.timezone}")
    private String timeZone;

    @Bean
    public DateFormat getDateFormatter() {
        DateFormat format = new SimpleDateFormat(dateFormat);
        format.setTimeZone(TimeZone.getTimeZone(timeZone));
        return format;
    }
}
