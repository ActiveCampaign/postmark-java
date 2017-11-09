package com.wildbit.java.postmark.client.data.model.triggers;

import java.util.ArrayList;

/**
 * Inbound rules POJO.
 */
public class InboundRules {

    private Integer totalCount;
    private ArrayList<InboundRuleResponse> inboundRules;

    // SETTERS AND GETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<InboundRuleResponse> getInboundRules() {
        return inboundRules;
    }

    public void setInboundRules(ArrayList<InboundRuleResponse> inboundRules) {
        this.inboundRules = inboundRules;
    }
}
