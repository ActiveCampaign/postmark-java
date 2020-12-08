package com.wildbit.java.postmark.client.data.model.streams;

import java.util.Date;

public class MessageStreamArchiveResponse {
    private String id;
    private String serverId;
    private Date expectedPurgeDate;

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

    public Date getExpectedPurgeDate() {
        return expectedPurgeDate;
    }

    public void setExpectedPurgeDate(Date expectedPurgeDate) {
        this.expectedPurgeDate = expectedPurgeDate;
    }
}
