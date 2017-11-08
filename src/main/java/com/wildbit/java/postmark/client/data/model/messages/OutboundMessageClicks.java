package com.wildbit.java.postmark.client.data.model.messages;

import java.util.ArrayList;

/**
 * Created by bash on 11/6/17.
 */
public class OutboundMessageClicks {
    private Integer totalCount;
    private ArrayList<OutboundMessageClick> clicks;

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
