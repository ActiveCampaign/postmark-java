package com.wildbit.java.postmark.client.data.model.webhooks.sent_payload;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Delivery webhook object.
 */
public class DeliveryWebhook {

    private Integer serverId;
    private String messageId;
    private String recipient;
    private String tag;
    private Date deliveredAt;
    private String details;
    private String recordType;
    private HashMap<String, String> metadata;

    // GETTERS AND SETTERS

    public HashMap<String, String> getMetadata() { return metadata; }

    public void setMetadata(HashMap<String, String> metadata) { this.metadata = metadata; }

    public String getRecordType() { return recordType; }

    public void setRecordType(String recordType) { this.recordType = recordType; }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Date deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
