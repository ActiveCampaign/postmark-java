package com.wildbit.java.postmark.client.data.model.templates;

import java.util.List;
import java.util.Map;

/**
 * Template validation field details object.
 */
public class TemplateValidationField {
    private Boolean contentIsValid;
    private List<Map<String,String>> validationErrors;
    private String renderedContent;

    // SETTERS AND GETTERS

    public Boolean getContentIsValid() {
        return contentIsValid;
    }

    public void setContentIsValid(Boolean contentIsValid) {
        this.contentIsValid = contentIsValid;
    }

    public List<Map<String, String>> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<Map<String, String>> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public String getRenderedContent() {
        return renderedContent;
    }

    public void setRenderedContent(String renderedContent) {
        this.renderedContent = renderedContent;
    }
}
