package com.wildbit.java.postmark.client.data.model.streams;

public class MessageStreams {
    private MessageStream[] messageStreams;
    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public MessageStream[] getMessageStreams() {
        return messageStreams;
    }

    public void setMessageStreams(MessageStream[] messageStreams) {
        this.messageStreams = messageStreams;
    }
}
