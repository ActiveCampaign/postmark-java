package com.wildbit.java.postmark.client.data.model.message;

/**
 * Created by bash on 9/4/17.
 */
public class Message extends BaseMessage {

    public enum TRACK_LINKS {
        Html("Html"),
        HtmlAndText("HtmlAndText"),
        Text("Text");

        public final String value;

        TRACK_LINKS(String value) {
            this.value = value;
        }
    }

    Boolean trackOpens;
    String trackLinks;

    public Message() {
        super();
    }

    public Message(String from, String to, String subject, String htmlBody) {
        super(from, to, subject, htmlBody);
    }

    public Message(String from, String to, String subject, String htmlBody, String textBody) {
        super(from, to, subject, htmlBody, textBody);
    }

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
