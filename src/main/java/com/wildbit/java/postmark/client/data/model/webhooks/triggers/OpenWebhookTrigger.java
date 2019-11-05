package com.wildbit.java.postmark.client.data.model.webhooks.triggers;

public class OpenWebhookTrigger extends WebhookTrigger {
    private boolean postFirstOpenOnly;

    public OpenWebhookTrigger() {
        super();
    }

    public OpenWebhookTrigger(boolean enabled) {
        super(enabled);
    }

    public OpenWebhookTrigger(boolean enabled, boolean postFirstOpenOnly) {
        super(enabled);
        this.postFirstOpenOnly = postFirstOpenOnly;
    }

    public boolean isPostFirstOpenOnly() {
        return postFirstOpenOnly;
    }

    public void setPostFirstOpenOnly(boolean postFirstOpenOnly) {
        this.postFirstOpenOnly = postFirstOpenOnly;
    }
}
