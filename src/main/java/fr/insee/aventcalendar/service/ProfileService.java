package fr.insee.aventcalendar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.aventcalendar.model.faq.QandA;
import fr.insee.aventcalendar.model.leaderboard.UsersProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Profiles;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProfileService {
    @Value("${profiles.location}")
    private String profilesLocation;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper mapper;

    private UsersProfile profilesCache;

    public UsersProfile getUsersProfiles() throws IOException {
        if (profilesCache != null) {
            return profilesCache;
        }
        profilesCache =  mapper.readValue(resourceLoader.getResource(profilesLocation).getInputStream(), UsersProfile.class);
        return profilesCache;
    }}
