package fr.insee.aventcalendar.model.calendar;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class CompletionDay {
    private Map<String, Challenge> dayChallengeList = new HashMap<>();

    public Map<String, Challenge> getDayChallengeList() {
        return dayChallengeList;
    }

    @JsonAnySetter
    public void setUnrecognizedFields(String key, Challenge value) {
            this.dayChallengeList.put(key, value);
    }
}
