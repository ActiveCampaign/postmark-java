package com.wildbit.java.postmark.client.data.model.messages;

import java.util.Date;
import java.util.Map;

/**
 * Outbound message open object.
 */
public class OutboundMessageOpen {

    private Map<String,String> client;
    private Map<String,String> os;
    private String platform;
    private String userAgent;
    private Integer readSeconds;
    private Map<String,String> geo;
    private String messageId;
    private Date receivedAt;
    private String tag;
    private String recipient;
    private String recordType;
    private String messageStream;

    // GETTERS AND SETTERS

    public String getMessageStream() {
        return messageStream;
    }

    public void setMessageStream(String messageStream) {
        this.messageStream = messageStream;
    }

    public String getRecordType() { return recordType; }

    public void setRecordType(String recordType) { this.recordType = recordType; }

    public Map<String, String> getClient() {
        return client;
    }

    public void setClient(Map<String, String> client) {
        this.client = client;
    }

    public Map<String, String> getOs() {
        return os;
    }

    public void setOs(Map<String, String> os) {
        this.os = os;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Integer getReadSeconds() {
        return readSeconds;
    }

    public void setReadSeconds(Integer readSeconds) {
        this.readSeconds = readSeconds;
    }

    public Map<String, String> getGeo() {
        return geo;
    }

    public void setGeo(Map<String, String> geo) {
        this.geo = geo;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
