package com.wildbit.java.postmark.client.data.model.webhooks;

import com.wildbit.java.postmark.client.data.model.messages.OutboundMessageOpen;

/**
 * Open webhook object.
 */
public class OpenWebhook extends OutboundMessageOpen {
    private Boolean firstOpen;

    public Boolean getFirstOpen() {
        return firstOpen;
    }

    public void setFirstOpen(Boolean firstOpen) {
        this.firstOpen = firstOpen;
    }
}
