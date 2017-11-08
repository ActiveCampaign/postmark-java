package com.wildbit.java.postmark.client.data.model.messages;

import java.util.ArrayList;

/**
 * Created by bash on 11/1/17.
 */
public class OutboundMessages {

    private Integer totalCount;
    private ArrayList<OutboundMessage> messages;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<OutboundMessage> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<OutboundMessage> messages) {
        this.messages = messages;
    }

}
