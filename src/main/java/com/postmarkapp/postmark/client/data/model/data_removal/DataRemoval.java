package com.postmarkapp.postmark.client.data.model.data_removal;

public class DataRemoval {
    private String requestedBy;
    private String requestedFor;
    private Boolean notifyWhenCompleted;

    public DataRemoval(String requestedBy, String requestedFor, Boolean notifyWhenCompleted) {
        this.requestedBy = requestedBy;
        this.requestedFor = requestedFor;
        this.notifyWhenCompleted = notifyWhenCompleted;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(String requestedFor) {
        this.requestedFor = requestedFor;
    }

    public Boolean getNotifyWhenCompleted() {
        return notifyWhenCompleted;
    }

    public void setNotifyWhenCompleted(Boolean notifyWhenCompleted) {
        this.notifyWhenCompleted = notifyWhenCompleted;
    }
}
