package fr.insee.aventcalendar.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DateServiceTest {

    @Test
    public void shallGetEqualString() {
        Long timestamp = Long.valueOf(0);
        DateService ds = new DateService("dd/MM/yyyy HH:mm:ss");
        assertEquals("01/01/1970 01:00:00", ds.formatDate(timestamp));
    }

    @Test
    public void shallGetSameString() {
        Long timestamp = Long.valueOf(0);
        DateService ds = new DateService("MM - dd - yyyy, HH : mm : ss");
        assertEquals("01 - 01 - 1970, 01 : 00 : 00", ds.formatDate(timestamp));
    }

}