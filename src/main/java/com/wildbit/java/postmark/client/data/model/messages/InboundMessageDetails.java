package com.wildbit.java.postmark.client.data.model.messages;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bash on 11/1/17.
 */
public class InboundMessageDetails extends InboundMessage {

    private String textBody;
    private String htmlBody;
    private String strippedTextReply;
    private ArrayList<HashMap<String, String>> headers;
    private String blockedReason;

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

    public ArrayList<HashMap<String, String>> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<HashMap<String, String>> headers) {
        this.headers = headers;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }
}
