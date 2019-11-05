package com.wildbit.java.postmark.client.data.model.webhooks.triggers;

public class WebhookTrigger {
    private boolean enabled;

    public WebhookTrigger() {

    }

    public WebhookTrigger(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
