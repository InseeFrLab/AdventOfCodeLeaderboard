package fr.insee.aventcalendar.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.insee.aventcalendar.model.leaderboard.UsersProfile;

@Service
public class ProfileService {
    @Value("${profiles.location}")
    private String profilesLocation;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper mapper;

    public UsersProfile getUsersProfiles() throws IOException {
        return mapper.readValue(resourceLoader.getResource(profilesLocation).getInputStream(), UsersProfile.class);
    }
}
