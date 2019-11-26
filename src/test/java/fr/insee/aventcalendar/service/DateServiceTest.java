package fr.insee.aventcalendar.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DateServiceTest {

    @Test
    public void shallGetEqualString() {
        Locale.setDefault(Locale.FRANCE);
        Long timestamp = Long.valueOf(0);
        DateService ds = new DateService("dd/MM/yyyy HH:mm:ss");
        assertEquals("01/01/1970 01:00:00", ds.formatDate(timestamp));
    }

    @Test
    public void shallGetSameString() {
        Locale.setDefault(Locale.FRANCE);
        Long timestamp = Long.valueOf(0);
        DateService ds = new DateService("MM - dd - yyyy, HH : mm : ss");
        assertEquals("01 - 01 - 1970, 01 : 00 : 00", ds.formatDate(timestamp));
    }

}