package fr.insee.aventcalendar.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    @Autowired
    private ZoneId zoneId;

    public String formatDate(Long timestamp) {
    	LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), zoneId);
        return ldt.format(dateTimeFormatter);
    }
}