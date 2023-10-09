package com.postmarkapp.postmark.client.data.model.data_removal;

public enum DataRemovalStatusTypes {
    Pending("Pending"),
    Done("Done");

    public final String value;

    DataRemovalStatusTypes(String value) {
        this.value = value;
    }
}
