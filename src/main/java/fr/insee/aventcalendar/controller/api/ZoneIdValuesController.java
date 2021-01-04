package fr.insee.aventcalendar.controller.api;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/zoneid")
public class ZoneIdValuesController {

    @GetMapping
    public Set<String> getQandA() throws IOException {
        return ZoneId.getAvailableZoneIds();
    }
}
