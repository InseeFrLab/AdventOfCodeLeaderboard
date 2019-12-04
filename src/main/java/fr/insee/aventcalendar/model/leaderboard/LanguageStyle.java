package fr.insee.aventcalendar.model.leaderboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class LanguageStyle {
    @JsonProperty("languages")
    private Map<String, String> style;

    public Map<String, String> getStyle() {
        return style;
    }

    public void setStyle(Map<String, String> style) {
        this.style = style;
    }
}
