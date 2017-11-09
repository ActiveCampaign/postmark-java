package com.wildbit.java.postmark.client.data.model.templates;

import java.util.ArrayList;

/**
 * Templates list object.
 */
public class Templates {

    private Integer totalCount;
    private ArrayList<BaseTemplate> templates;

    // SETTERS AND GETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<BaseTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(ArrayList<BaseTemplate> templates) {
        this.templates = templates;
    }
}
