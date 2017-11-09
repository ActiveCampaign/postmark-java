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

    Boolean trackOpens;
    String trackLinks;

    // SETTERS AND GETTERS

    public TemplatedMessage() {
        super();
    }

    public TemplatedMessage(String from, String to) {
        super(from, to);
    }

}
