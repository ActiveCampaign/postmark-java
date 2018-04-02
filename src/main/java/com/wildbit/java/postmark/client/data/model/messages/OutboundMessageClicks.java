package com.wildbit.java.postmark.client.data.model.messages;

import java.util.List;

/**
 * Outbound message clicks object.
 */
public class OutboundMessageClicks {
    private Integer totalCount;
    private List<OutboundMessageClick> clicks;

    // GETTERS AND SETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<OutboundMessageClick> getClicks() {
        return clicks;
    }

    public void setClicks(List<OutboundMessageClick> clicks) {
        this.clicks = clicks;
    }
}
