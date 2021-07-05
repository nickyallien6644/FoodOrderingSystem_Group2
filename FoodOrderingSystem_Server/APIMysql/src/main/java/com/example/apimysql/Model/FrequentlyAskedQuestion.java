package com.example.apimysql.Model;

public class FrequentlyAskedQuestion {
    private int faqID;
    private String faqQuestion;
    private String faqAnswer;

    public FrequentlyAskedQuestion(int faqID, String faqQuestion, String faqAnswer) {
        this.faqID = faqID;
        this.faqQuestion = faqQuestion;
        this.faqAnswer = faqAnswer;
    }

    public int getFaqID() {
        return faqID;
    }

    public void setFaqID(int faqID) {
        this.faqID = faqID;
    }

    public String getFaqQuestion() {
        return faqQuestion;
    }

    public void setFaqQuestion(String faqQuestion) {
        this.faqQuestion = faqQuestion;
    }

    public String getFaqAnswer() {
        return faqAnswer;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer;
    }
}
