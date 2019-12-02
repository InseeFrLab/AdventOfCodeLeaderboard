package fr.insee.aventcalendar.model.faq;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

public class QandA {

    private List<QACategory> categories;

    public List<QACategory> getCategories() {
        return categories;
    }

    public void setCategories(List<QACategory> categories) {
        this.categories = categories;
    }
}
