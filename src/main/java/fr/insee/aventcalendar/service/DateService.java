package fr.insee.aventcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class DateService {

    @Autowired
    private DateFormat dateFormat;

    public String formatDate(Long timestamp) {
        Date date = new Date(timestamp*1000);
        return dateFormat.format(date);
    }
}