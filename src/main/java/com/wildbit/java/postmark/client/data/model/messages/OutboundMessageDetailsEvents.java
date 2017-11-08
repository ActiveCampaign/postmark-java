package com.wildbit.java.postmark.client.data.model.messages;

import java.util.HashMap;

/**
 * Created by bash on 11/6/17.
 */
public class OutboundMessageDetailsEvents {

    private String recipient;
    private String type;
    private String receivedAt;
    private HashMap<String,String> details;

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

    public String getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(String receivedAt) {
        this.receivedAt = receivedAt;
    }

    public HashMap<String, String> getDetails() {
        return details;
    }

    public void setDetails(HashMap<String, String> details) {
        this.details = details;
    }
}
