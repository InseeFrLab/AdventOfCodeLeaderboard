package fr.insee.aventcalendar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DateServiceWithDefaultTimePropertiesTest {

    @Autowired
    private DateService dateService;

    @Test
    // Default time is Paris time with winter hour (UTC + 1h during winter) !
    public void shallGetEqualStringInWinter() {
        Long timestamp = Long.valueOf(0);
        assertEquals("01/01/1970 01:00:00", dateService.formatDate(timestamp));
    }

    @Test
    // Default time is Paris time with summer hour (UTC + 2h during summer) !
    public void shallGetEqualStringInSummer() {
    	ZonedDateTime zdt = LocalDateTime.of(2020, 07, 01, 12, 00, 00).atZone(ZoneId.of("GMT"));
        assertEquals("01/07/2020 14:00:00", dateService.formatDate(zdt.toEpochSecond()));
    }

}