package com.wildbit.java.postmark.client.data.model.messages;

import java.util.List;

/**
 * Outbound message details object.
 */
public class OutboundMessageDetails extends OutboundMessage {

    private String textBody;
    private String htmlBody;
    private String body;
    private List<OutboundMessageDetailsEvents> messageEvents;

    // GETTERS AND SETTERS

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<OutboundMessageDetailsEvents> getMessageEvents() {
        return messageEvents;
    }

    public void setMessageEvents(List<OutboundMessageDetailsEvents> messageEvents) {
        this.messageEvents = messageEvents;
    }
}
