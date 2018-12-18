package com.wildbit.java.postmark.client.data.model.templates;

public class TemplatesPushRequest {
    private Integer sourceServerId;
    private Integer destinationServerId;
    private Boolean performChanges;

    public TemplatesPushRequest(Integer sourceServerId, Integer destinationServerId, Boolean performChanges) {
        this.sourceServerId = sourceServerId;
        this.destinationServerId = destinationServerId;
        this.performChanges = performChanges;
    }

    public TemplatesPushRequest(Integer sourceServerId, Integer destinationServerId) {
        this.sourceServerId = sourceServerId;
        this.destinationServerId = destinationServerId;
        this.performChanges = true;
    }

    // SETTERS AND GETTERS

    public Integer getSourceServerId() {
        return sourceServerId;
    }

    public void setSourceServerId(Integer sourceServerId) {
        this.sourceServerId = sourceServerId;
    }

    public Integer getDestinationServerId() {
        return destinationServerId;
    }

    public void setDestinationServerId(Integer destinationServerId) {
        this.destinationServerId = destinationServerId;
    }

    public Boolean getPerformChanges() {
        return performChanges;
    }

    public void setPerformChanges(Boolean performChanges) {
        this.performChanges = performChanges;
    }
}
