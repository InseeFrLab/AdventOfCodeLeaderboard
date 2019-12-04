package fr.insee.aventcalendar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.leaderboard.LanguageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LanguageStyleService {
    @Value("${languageStyle.location}")
    private String languageStyleLocation;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper mapper;

    private LanguageStyle languageStyleCache;

    public LanguageStyle getLanguageStyle() throws IOException {
        if (languageStyleCache != null) {
            return languageStyleCache;
        }
        languageStyleCache =  mapper.readValue(resourceLoader.getResource(languageStyleLocation).getInputStream(), LanguageStyle.class);
        return languageStyleCache;
    }
}
