package fr.insee.aventcalendar.model.leaderboard;

import java.util.Map;

public class Profiles {
    private Map<String, String> language;
    private Map<String, String> link;

    public Map<String, String> getLanguage() {
        return language;
    }

    public void setLanguage(Map<String, String> language) {
        this.language = language;
    }

    public Map<String, String> getLink() {
        return link;
    }

    public void setLink(Map<String, String> link) {
        this.link = link;
    }
}
