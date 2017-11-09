package com.wildbit.java.postmark.client.data.model.templates;

/**
 * Basic Template with no details POJO.
 */
public class BaseTemplate {

    private Boolean active;
    private String name;
    private Integer templateId;

    // SETTERS AND GETTERS

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
