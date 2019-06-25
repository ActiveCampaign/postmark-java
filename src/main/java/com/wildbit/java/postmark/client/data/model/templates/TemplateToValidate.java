package com.wildbit.java.postmark.client.data.model.templates;

/**
 * Template validation object.
 */
public class TemplateToValidate {
    private String subject;
    private String htmlBody;
    private String textBody;
    private Object testRenderModel;
    private TemplateTypes templateType;
    private String layoutTemplate;
    private Boolean inlineCssForHtmlTestRender;

    // SETTERS AND GETTERS

    public Object getTestRenderModel() {
        return testRenderModel;
    }

    public void setTestRenderModel(Object testRenderModel) {
        this.testRenderModel = testRenderModel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public TemplateTypes getTemplateType() { return templateType; }

    public void setTemplateType(TemplateTypes templateType) { this.templateType = templateType; }

    public Boolean getInlineCssForHtmlTestRender() { return inlineCssForHtmlTestRender; }

    public void setInlineCssForHtmlTestRender(Boolean inlineCssForHtmlTestRender) {
        this.inlineCssForHtmlTestRender = inlineCssForHtmlTestRender;
    }

    public String getLayoutTemplate() { return layoutTemplate; }

    public void setLayoutTemplate(String layoutTemplate) { this.layoutTemplate = layoutTemplate; }
}
