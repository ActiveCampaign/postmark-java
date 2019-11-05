package com.wildbit.java.postmark.client.data.model.webhooks.triggers;

public class BounceWebhookTrigger extends WebhookTrigger {
    private boolean includeContent;

    public BounceWebhookTrigger() {
        super();
    }

    public BounceWebhookTrigger(boolean enabled) {
        super(enabled);
    }

    public BounceWebhookTrigger(boolean enabled, boolean includeContent) {
        super(enabled);
        this.includeContent = includeContent;
    }

    public boolean isIncludeContent() {
        return includeContent;
    }

    public void setIncludeContent(boolean includeContent) {
        this.includeContent = includeContent;
    }
}
