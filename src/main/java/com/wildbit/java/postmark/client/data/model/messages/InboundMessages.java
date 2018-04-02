package com.wildbit.java.postmark.client.data.model.messages;

import java.util.List;

/**
 * Inbound messages object.
 */
public class InboundMessages {

    private Integer totalCount;
    private List<InboundMessage> inboundMessages;

    // GETTERS AND SETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<InboundMessage> getInboundMessages() {
        return inboundMessages;
    }

    public void setInboundMessages(List<InboundMessage> inboundMessages) {
        this.inboundMessages = inboundMessages;
    }
}
