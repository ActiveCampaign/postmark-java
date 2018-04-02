package com.wildbit.java.postmark.client.data.model.messages;

import java.util.List;

/**
 * Outbound message opens object.
 */
public class OutboundMessageOpens {
    private Integer totalCount;
    private List<OutboundMessageOpen> opens;

    // GETTERS AND SETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<OutboundMessageOpen> getOpens() {
        return opens;
    }

    public void setOpens(List<OutboundMessageOpen> opens) {
        this.opens = opens;
    }
}
