package com.wildbit.java.postmark.client.data.model.messages;

import java.util.ArrayList;

/**
 * Outbound message clicks POJO.
 */
public class OutboundMessageClicks {
    private Integer totalCount;
    private ArrayList<OutboundMessageClick> clicks;

    // GETTERS AND SETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<OutboundMessageClick> getClicks() {
        return clicks;
    }

    public void setClicks(ArrayList<OutboundMessageClick> clicks) {
        this.clicks = clicks;
    }
}
