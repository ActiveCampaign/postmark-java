package com.wildbit.java.postmark.client.data.model.messages;

import java.util.Date;
import java.util.HashMap;

/**
 * Outbound message details object.
 */
public class OutboundMessageDetailsEvents {

    private String recipient;
    private String type;
    private Date receivedAt;
    private HashMap<String,String> details;

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

    public HashMap<String, String> getDetails() {
        return details;
    }

    public void setDetails(HashMap<String, String> details) {
        this.details = details;
    }
}
