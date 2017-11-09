package com.wildbit.java.postmark.client.data.model.messages;

import java.util.Date;
import java.util.HashMap;

/**
 * Outbound message click POJO.
 */
public class OutboundMessageClick {

    private String clickLocation;
    private HashMap<String,String> client;
    private HashMap<String,String> os;
    private String platform;
    private String userAgent;
    private String originalLink;
    private HashMap<String,String> geo;
    private String messageId;
    private Date receivedAt;
    private String tag;
    private String recipient;

    // GETTERS AND SETTERS

    public String getClickLocation() {
        return clickLocation;
    }

    public void setClickLocation(String clickLocation) {
        this.clickLocation = clickLocation;
    }

    public HashMap<String, String> getClient() {
        return client;
    }

    public void setClient(HashMap<String, String> client) {
        this.client = client;
    }

    public HashMap<String, String> getOs() {
        return os;
    }

    public void setOs(HashMap<String, String> os) {
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

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public HashMap<String, String> getGeo() {
        return geo;
    }

    public void setGeo(HashMap<String, String> geo) {
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
