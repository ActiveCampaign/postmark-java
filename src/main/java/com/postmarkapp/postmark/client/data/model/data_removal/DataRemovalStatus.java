package com.postmarkapp.postmark.client.data.model.data_removal;

public class DataRemovalStatus {
    private Integer id;
    private DataRemovalStatusTypes status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DataRemovalStatusTypes getStatus() {
        return status;
    }

    public void setStatus(DataRemovalStatusTypes status) {
        this.status = status;
    }
}
