package com.wildbit.java.postmark.client.data.model.templates;

import java.util.List;

public class TemplatesPush {
    private Integer totalCount;
    private List<TemplatesPushAction> templates;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<TemplatesPushAction> getTemplates() {
        return templates;
    }

    public void setTemplates(List<TemplatesPushAction> templates) {
        this.templates = templates;
    }
}
