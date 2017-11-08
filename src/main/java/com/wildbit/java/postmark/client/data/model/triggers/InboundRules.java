package com.wildbit.java.postmark.client.data.model.triggers;

import java.util.ArrayList;

/**
 * Created by bash on 11/7/17.
 */
public class InboundRules {

    private Integer totalCount;
    private ArrayList<InboundRuleResponse> inboundRules;

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
