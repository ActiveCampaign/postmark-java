package com.wildbit.java.postmark.client.data.model.triggers;

import java.util.List;

/**
 * Inbound rules object.
 */
public class InboundRules {

    private Integer totalCount;
    private List<InboundRuleResponse> inboundRules;

    // SETTERS AND GETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<InboundRuleResponse> getInboundRules() {
        return inboundRules;
    }

    public void setInboundRules(List<InboundRuleResponse> inboundRules) {
        this.inboundRules = inboundRules;
    }
}
