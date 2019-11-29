package fr.insee.aventcalendar.model.faq;

import java.util.List;

public class QACategory {

    private String category;
    private List<QAQuestion> questions;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<QAQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QAQuestion> questions) {
        this.questions = questions;
    }
}
