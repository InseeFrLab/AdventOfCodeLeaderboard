package fr.insee.aventcalendar.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DateServiceTest {

    @Autowired
    private DateService dateService;

    @Test
    public void shallGetEqualString() {
        Long timestamp = Long.valueOf(0);
        assertEquals("01/01/1970 00:00:00", dateService.formatDate(timestamp));
    }

}