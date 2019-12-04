package fr.insee.aventcalendar.model.leaderboard;

import java.util.Map;

public class UsersProfile {
    private Map<String, Profiles> profiles;

    public Map<String, Profiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(Map<String, Profiles> profiles) {
        this.profiles = profiles;
    }
}
