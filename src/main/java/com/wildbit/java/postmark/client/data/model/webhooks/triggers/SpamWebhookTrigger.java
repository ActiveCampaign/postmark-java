package com.wildbit.java.postmark.client.data.model.webhooks.triggers;

public class SpamWebhookTrigger extends BounceWebhookTrigger {
    public SpamWebhookTrigger() {
        super();
    }

    public SpamWebhookTrigger(boolean enabled) {
        super(enabled);
    }

    public SpamWebhookTrigger(boolean enabled, boolean includeContent) {
        super(enabled, includeContent);
    }
}
