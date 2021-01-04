package fr.insee.aventcalendar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test-with-time-properties")
class DateServiceWithTimePropertiesTest {

    @Autowired
    private DateService dateService;

    @Test
    public void shallGetEqualString() {
        Long timestamp = Long.valueOf(0);
        assertEquals("01-01-1970T00:00:00", dateService.formatDate(timestamp));
    }

}