package com.wildbit.java.postmark.client.data.model.templates;

/**
 * Created by bash on 11/7/17.
 */
public class TemplateBase {

    private Boolean active;
    private String name;
    private Integer templateId;

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
