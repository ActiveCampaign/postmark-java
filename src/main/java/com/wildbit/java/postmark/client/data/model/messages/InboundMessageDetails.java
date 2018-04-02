package com.wildbit.java.postmark.client.data.model.messages;

import java.util.List;
import java.util.Map;

/**
 * Inbound message details object.
 */
public class InboundMessageDetails extends InboundMessage {

    private String textBody;
    private String htmlBody;
    private String strippedTextReply;
    private List<Map<String, String>> headers;
    private String blockedReason;

    // GETTERS AND SETTERS

    public String getStrippedTextReply() {
        return strippedTextReply;
    }

    public void setStrippedTextReply(String strippedTextReply) {
        this.strippedTextReply = strippedTextReply;
    }

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

    public List<Map<String, String>> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Map<String, String>> headers) {
        this.headers = headers;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }
}
