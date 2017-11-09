package com.wildbit.java.postmark.client.data.model.messages;

import java.util.ArrayList;

/**
 * Inbound messages object.
 */
public class InboundMessages {

    private Integer totalCount;
    private ArrayList<InboundMessage> inboundMessages;

    // GETTERS AND SETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<InboundMessage> getInboundMessages() {
        return inboundMessages;
    }

    public void setInboundMessages(ArrayList<InboundMessage> inboundMessages) {
        this.inboundMessages = inboundMessages;
    }
}
