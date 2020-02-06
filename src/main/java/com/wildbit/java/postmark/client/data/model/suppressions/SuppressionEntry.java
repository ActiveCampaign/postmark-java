package com.wildbit.java.postmark.client.data.model.suppressions;

public class SuppressionEntry {
    private String emailAddress;

    public SuppressionEntry(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
