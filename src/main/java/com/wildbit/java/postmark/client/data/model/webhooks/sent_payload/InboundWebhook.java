package com.wildbit.java.postmark.client.data.model.webhooks.sent_payload;

import com.wildbit.java.postmark.client.data.model.messages.InboundMessageDetails;

public class InboundWebhook extends InboundMessageDetails {

    private String rawEmail;

    // GETTERS AND SETTERS

    public String getRawEmail() {
        return rawEmail;
    }

    public void setRawEmail(String rawEmail) {
        this.rawEmail = rawEmail;
    }
}
