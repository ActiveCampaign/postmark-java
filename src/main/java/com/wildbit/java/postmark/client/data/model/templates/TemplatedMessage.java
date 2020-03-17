package com.wildbit.java.postmark.client.data.model.templates;

import java.util.Map;
import java.util.HashMap;

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
    private Map<String, String> metadata;

    public TemplatedMessage() {
        super();
    }

    public TemplatedMessage(String from, String to) {
        super(from, to);
    }

    public TemplatedMessage(String from, String to, Integer templateId) {
        super(from, to, templateId);
    }

    public TemplatedMessage(String from, String to, String templateAlias) {
        super(from, to, templateAlias);
    }

    public TemplatedMessage(String from, String to, String templateAlias, String messageStream) {
        super(from, to, templateAlias, messageStream);
    }

    public TemplatedMessage(String from, String to, Integer templateId, String messageStream) {
        super(from, to, templateId, messageStream);
    }

    // SETTERS AND GETTERS

    public Boolean getTrackOpens() { return trackOpens; }

    public void setTrackOpens(Boolean trackOpens) { this.trackOpens = trackOpens; }

    public String getTrackLinks() { return trackLinks; }

    public void setTrackLinks(String trackLinks) { this.trackLinks = trackLinks; }

    public Map<String, String> getMetadata() { return metadata; }

    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

    public void addMetadata(String key, String value) {
        if (metadata == null) {
            metadata = new HashMap<>();
        }
        metadata.put(key,value);
    }
}
