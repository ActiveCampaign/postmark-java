package com.wildbit.java.postmark.client.data.model.templates;

/**
 * Template Content object.
 */
public class TemplateContent {
    private String name;
    private String subject;
    private String htmlBody;
    private String textBody;
    private String alias;

    // SETTERS AND GETTERS

    public String getAlias() { return alias; }

    public void setAlias(String alias) { this.alias = alias; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
