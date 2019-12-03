package fr.insee.aventcalendar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.mediaSection.MediaButton;
import fr.insee.aventcalendar.model.mediaSection.MediaSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MediaSectionService {

    @Value("${mediaSection.location}")
    private String mediaLocation;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper mapper;

    private MediaSection mediaSectionCache;
    public MediaSection getMediaSection() throws IOException {
        if (mediaSectionCache != null) {
            return mediaSectionCache;
        }
        mediaSectionCache =  mapper.readValue(resourceLoader.getResource(mediaLocation).getInputStream(), MediaSection.class);
        return mediaSectionCache;
    }
}

