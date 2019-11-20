package fr.insee.aventcalendar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("name")
    private String username = "";
    @JsonProperty("local_score")
    private Integer score = 0;
    private String language = null;
    private String link = null;
    private String id = null;
    @JsonProperty("completion_day_level")
    private CompletionDayList completionDayLevel = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public CompletionDayList getCompletionDayLevel() {
        return completionDayLevel;
    }

    public void setCompletionDayLevel(CompletionDayList completionDayLevel) {
        this.completionDayLevel = completionDayLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
