package com.wildbit.java.postmark.client.data.model.templates;

/**
 * Basic Template with no details object.
 */
public class BaseTemplate {

    private String alias;
    private Boolean active;
    private String name;
    private Integer templateId;

    // SETTERS AND GETTERS

    public String getAlias() { return alias; }

    public void setAlias(String alias) { this.alias = alias; }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
}
