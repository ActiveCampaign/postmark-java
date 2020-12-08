package com.wildbit.java.postmark.client.data.model.streams;

import java.util.Date;

public class MessageStream {
    private String id;
    private String serverId;
    private String name;
    private String description;
    private String messageStreamType;
    private Date createdAt;
    private Date updatedAt;
    private Date archivedAt;
    private Date expectedPurgeDate;
    private SubscriptionManagementConfiguration subscriptionManagementConfiguration;

    public MessageStream() {}
    public MessageStream(String id, String name, String description, String messageStreamType,
                         SubscriptionManagementConfiguration subscriptionManagementConfiguration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.messageStreamType = messageStreamType;
        this.subscriptionManagementConfiguration = subscriptionManagementConfiguration;
    }

    public MessageStream(String id, String name, String messageStreamType,
                         SubscriptionManagementConfiguration subscriptionManagementConfiguration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.messageStreamType = messageStreamType;
        this.subscriptionManagementConfiguration = subscriptionManagementConfiguration;
    }

    public MessageStream(String id, String name, String messageStreamType) {
        this.id = id;
        this.name = name;
        this.messageStreamType = messageStreamType;
        this.subscriptionManagementConfiguration = new SubscriptionManagementConfiguration();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessageStreamType() {
        return messageStreamType;
    }

    public void setMessageStreamType(String messageStreamType) {
        this.messageStreamType = messageStreamType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(Date archivedAt) {
        this.archivedAt = archivedAt;
    }

    public Date getExpectedPurgeDate() {
        return expectedPurgeDate;
    }

    public void setExpectedPurgeDate(Date expectedPurgeDate) {
        this.expectedPurgeDate = expectedPurgeDate;
    }

    public SubscriptionManagementConfiguration getSubscriptionManagementConfiguration() {
        return subscriptionManagementConfiguration;
    }

    public void setSubscriptionManagementConfiguration(SubscriptionManagementConfiguration subscriptionManagementConfiguration) {
        this.subscriptionManagementConfiguration = subscriptionManagementConfiguration;
    }
}
