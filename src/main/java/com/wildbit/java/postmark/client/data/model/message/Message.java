package com.wildbit.java.postmark.client.data.model.message;

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

    public Message() {
        super();
    }

    public Message(String from, String to, String subject, String htmlBody) {
        super(from, to, subject, htmlBody);
    }

    public Message(String from, String to, String subject, String htmlBody, String textBody) {
        super(from, to, subject, htmlBody, textBody);
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

    public void setTrackLinks(TRACK_LINKS trackLinks) {
        this.trackLinks = trackLinks.value;
    }

}
