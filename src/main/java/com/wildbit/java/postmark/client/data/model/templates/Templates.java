package com.wildbit.java.postmark.client.data.model.templates;

import java.util.ArrayList;

/**
 * Created by bash on 11/7/17.
 */
public class Templates {

    private Integer totalCount;
    private ArrayList<TemplateBase> templates;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<TemplateBase> getTemplates() {
        return templates;
    }

    public void setTemplates(ArrayList<TemplateBase> templates) {
        this.templates = templates;
    }
}
