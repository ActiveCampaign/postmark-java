package com.wildbit.java.postmark.client.data.model.messages;

import java.util.List;

/**
 * Outbound messages object.
 */
public class OutboundMessages {

    private Integer totalCount;
    private List<OutboundMessage> messages;

    // GETTERS AND SETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<OutboundMessage> getMessages() { return messages; }

    public void setMessages(List<OutboundMessage> messages) {
        this.messages = messages;
    }

}
