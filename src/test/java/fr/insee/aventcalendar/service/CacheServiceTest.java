package fr.insee.aventcalendar.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CacheServiceTest {

    @Test
    public void shallReturnEmpty() {
        CacheService cs = new CacheService(2);
        assertAll("empty",
                () -> assertEquals(0, cs.getUserCache().size()),
                () -> assertNull(cs.getUserCache().getIfPresent("2018"))
        );
    }

}