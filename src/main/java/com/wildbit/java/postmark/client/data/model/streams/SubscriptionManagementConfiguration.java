package com.wildbit.java.postmark.client.data.model.streams;

public class SubscriptionManagementConfiguration {
    private String unsubscribeHandlingType;

    public SubscriptionManagementConfiguration() {
        this.unsubscribeHandlingType = "Postmark";
    }

    public SubscriptionManagementConfiguration(String unsubscribeHandlingType) {
        this.unsubscribeHandlingType = unsubscribeHandlingType;
    }


    public String getUnsubscribeHandlingType() {
        return unsubscribeHandlingType;
    }

    public void setUnsubscribeHandlingType(String unsubscribeHandlingType) {
        this.unsubscribeHandlingType = unsubscribeHandlingType;
    }
}
