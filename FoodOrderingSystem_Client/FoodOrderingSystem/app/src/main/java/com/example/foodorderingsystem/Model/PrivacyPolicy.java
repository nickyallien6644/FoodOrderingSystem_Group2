package com.example.foodorderingsystem.Model;

public class PrivacyPolicy {
    private int privacyID;
    private String privacyTitle;
    private String privacyContent;

    public PrivacyPolicy(int privacyID, String privacyTitle, String privacyContent) {
        this.privacyID = privacyID;
        this.privacyTitle = privacyTitle;
        this.privacyContent = privacyContent;
    }

    public int getPrivacyID() {
        return privacyID;
    }

    public void setPrivacyID(int privacyID) {
        this.privacyID = privacyID;
    }

    public String getPrivacyTitle() {
        return privacyTitle;
    }

    public void setPrivacyTitle(String privacyTitle) {
        this.privacyTitle = privacyTitle;
    }

    public String getPrivacyContent() {
        return privacyContent;
    }

    public void setPrivacyContent(String privacyContent) {
        this.privacyContent = privacyContent;
    }
}
