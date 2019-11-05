package com.wildbit.java.postmark.client.data.model.webhooks;

import java.util.List;

public class Webhooks {
    private List<Webhook> webhooks;

    public List<Webhook> getWebhooks() {
        return webhooks;
    }

    public void setWebhooks(List<Webhook> webhooks) {
        this.webhooks = webhooks;
    }
}
