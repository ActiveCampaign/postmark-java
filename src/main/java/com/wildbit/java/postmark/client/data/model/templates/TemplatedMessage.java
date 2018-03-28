package com.wildbit.java.postmark.client.data.model.templates;

/**
 * Template Message with all details object.
 */
public class TemplatedMessage extends BaseTemplatedMessage {

    public enum TRACK_LINKS {
        Html("Html"),
        HtmlAndText("HtmlAndText"),
        Text("Text");

        public final String value;

        TRACK_LINKS(String value) {
            this.value = value;
        }
    }

    private Boolean trackOpens;
    private String trackLinks;

    // SETTERS AND GETTERS

    public Boolean getTrackOpens() { return trackOpens; }

    public void setTrackOpens(Boolean trackOpens) { this.trackOpens = trackOpens; }

    public String getTrackLinks() { return trackLinks; }

    public void setTrackLinks(String trackLinks) { this.trackLinks = trackLinks; }

    public TemplatedMessage() {
        super();
    }

    public TemplatedMessage(String from, String to) {
        super(from, to);
    }

    public TemplatedMessage(String from, String to, Integer templateId) {
        super(from, to, templateId);
    }

}
