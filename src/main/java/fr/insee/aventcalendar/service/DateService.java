package fr.insee.aventcalendar.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class DateService {
    private SimpleDateFormat simpleDateFormat;

    public DateService(@Value("${date.format}") String dateFormat) {
        simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public String formatDate(Long timestamp) {
        Date date = new Date(timestamp*1000);
        return simpleDateFormat.format(date);
    }
}