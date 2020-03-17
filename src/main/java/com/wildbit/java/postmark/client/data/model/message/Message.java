package com.wildbit.java.postmark.client.data.model.message;

import java.util.HashMap;
import java.util.Map;

/**
 * Postmark email message object
 */
public class Message extends BaseMessage {

    public enum TRACK_LINKS {
        Html("HtmlOnly"),
        HtmlAndText("HtmlAndText"),
        Text("TextOnly");

        public final String value;

        TRACK_LINKS(String value) {
            this.value = value;
        }
    }

    private Boolean trackOpens;
    private String trackLinks;
    private Map<String, String> metadata;

    public Message() {
        super();
    }

    public Message(String from, String to, String subject, String htmlBody) {
        super(from, to, subject, htmlBody);
    }

    public Message(String from, String to, String subject, String htmlBody, String textBody) {
        super(from, to, subject, htmlBody, textBody);
    }

    public Message(String from, String to, String subject, String htmlBody, String textBody, String messageStream) {
        super(from, to, subject, htmlBody, textBody, messageStream);
    }

    // SETTERS AND GETTERS

    public Boolean getTrackOpens() {
        return trackOpens;
    }

    public void setTrackOpens(Boolean trackOpens) {
        this.trackOpens = trackOpens;
    }

    public String getTrackLinks() {
        return trackLinks;
    }

    public void setTrackLinks(TRACK_LINKS trackLinks) { this.trackLinks = trackLinks.value; }

    public Map<String, String> getMetadata() { return metadata; }

    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

    public void addMetadata(String key, String value) {
        if (metadata == null) {
            metadata = new HashMap<String, String>();
        }
        metadata.put(key,value);
    }
}
