package com.wildbit.java.postmark.client.data.model.templates;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Template validation field details object.
 */
public class TemplateValidationField {
    private Boolean contentIsValid;
    private ArrayList<HashMap<String,String>> validationErrors;
    private String renderedContent;

    // SETTERS AND GETTERS

    public Boolean getContentIsValid() {
        return contentIsValid;
    }

    public void setContentIsValid(Boolean contentIsValid) {
        this.contentIsValid = contentIsValid;
    }

    public ArrayList<HashMap<String, String>> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(ArrayList<HashMap<String, String>> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public String getRenderedContent() {
        return renderedContent;
    }

    public void setRenderedContent(String renderedContent) {
        this.renderedContent = renderedContent;
    }
}
