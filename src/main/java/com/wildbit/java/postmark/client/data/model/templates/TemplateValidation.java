package com.wildbit.java.postmark.client.data.model.templates;

/**
 * Created by bash on 11/6/17.
 */
public class TemplateValidation {
    private Boolean allContentIsValid;
    private TemplateValidationField htmlBody;
    private TemplateValidationField textBody;
    private TemplateValidationField subject;
    private Object suggestedTemplateModel;

    public Boolean getAllContentIsValid() {
        return allContentIsValid;
    }

    public void setAllContentIsValid(Boolean allContentIsValid) {
        this.allContentIsValid = allContentIsValid;
    }

    public TemplateValidationField getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(TemplateValidationField htmlBody) {
        this.htmlBody = htmlBody;
    }

    public TemplateValidationField getTextBody() {
        return textBody;
    }

    public void setTextBody(TemplateValidationField textBody) {
        this.textBody = textBody;
    }

    public TemplateValidationField getSubject() {
        return subject;
    }

    public void setSubject(TemplateValidationField subject) {
        this.subject = subject;
    }

    public Object getSuggestedTemplateModel() {
        return suggestedTemplateModel;
    }

    public void setSuggestedTemplateModel(Object suggestedTemplateModel) {
        this.suggestedTemplateModel = suggestedTemplateModel;
    }
}
