package com.wildbit.java.postmark.client.data.model.templates;

public enum TemplateTypes {
    Standard("Standard"),
    Layout("Layout");

    public final String value;

    TemplateTypes(String value) {
        this.value = value;
    }
}