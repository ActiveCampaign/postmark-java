package com.wildbit.java.postmark.client.data.model.messages;

import java.util.Date;
import java.util.Map;

/**
 * Outbound message details object.
 */
public class OutboundMessageDetailsEvents {

    private String recipient;
    private String type;
    private Date receivedAt;
    private Map<String,String> details;

    // GETTERS AND SETTERS

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }
}
