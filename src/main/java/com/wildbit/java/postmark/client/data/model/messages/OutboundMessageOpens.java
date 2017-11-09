package com.wildbit.java.postmark.client.data.model.messages;

import java.util.ArrayList;

/**
 * Outbound message opens POJO.
 */
public class OutboundMessageOpens {
    private Integer totalCount;
    private ArrayList<OutboundMessageOpen> opens;

    // GETTERS AND SETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<OutboundMessageOpen> getOpens() {
        return opens;
    }

    public void setOpens(ArrayList<OutboundMessageOpen> opens) {
        this.opens = opens;
    }
}
