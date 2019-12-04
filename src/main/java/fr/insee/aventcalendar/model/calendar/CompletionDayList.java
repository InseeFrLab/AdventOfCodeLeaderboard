package fr.insee.aventcalendar.model.calendar;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class CompletionDayList {
    private Map<String, CompletionDay> completionDayList = new HashMap<>();

    public Map<String, CompletionDay> getCompletionDayList() {
        return completionDayList;
    }

    @JsonAnySetter
    public void setUnrecognizedFields(String key, CompletionDay value) {
            this.completionDayList.put(key, value);
    }

    public Integer getSumStar() {
        Integer result = 0;
        for (Map.Entry<String, CompletionDay> day : completionDayList.entrySet()) {
            result += day.getValue().getDayStarNumber();
        }
        return result;
    }
}
