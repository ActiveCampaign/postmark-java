package com.postmarkapp.postmark.client.data.model.webhooks;

public class SubscriptionChange {
    private Boolean enabled;

    public SubscriptionChange() {}

    public SubscriptionChange(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
