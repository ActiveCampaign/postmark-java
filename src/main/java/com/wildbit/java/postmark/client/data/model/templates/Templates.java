package com.wildbit.java.postmark.client.data.model.templates;

import java.util.List;

/**
 * Templates list object.
 */
public class Templates {

    private Integer totalCount;
    private List<BaseTemplate> templates;

    // SETTERS AND GETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<BaseTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<BaseTemplate> templates) {
        this.templates = templates;
    }
}
