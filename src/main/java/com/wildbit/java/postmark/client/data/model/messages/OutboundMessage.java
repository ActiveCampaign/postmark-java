package com.wildbit.java.postmark.client.data.model.messages;

import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * Outbound message object.
 */
public class OutboundMessage {

    private String tag;
    private String messageId;
    private List<Recipient> to;
    private List<Recipient> cc;
    private List<Recipient> bcc;
    private List<String> recipients;
    private Date receivedAt;
    private String from;
    private String subject;
    private List<String> attachments;
    private String status;
    private Boolean trackOpens;
    private String trackLinks;
    private Map<String, String> metadata;
    private String messageStream;

    // GETTERS AND SETTERS

    public String getMessageStream() {
        return messageStream;
    }

    public void setMessageStream(String messageStream) {
        this.messageStream = messageStream;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public List<Recipient> getTo() {
        return to;
    }

    public void setTo(List<Recipient> to) {
        this.to = to;
    }

    public List<Recipient> getCc() {
        return cc;
    }

    public void setCc(List<Recipient> cc) {
        this.cc = cc;
    }

    public List<Recipient> getBcc() {
        return bcc;
    }

    public void setBcc(List<Recipient> bcc) {
        this.bcc = bcc;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setTrackLinks(String trackLinks) {
        this.trackLinks = trackLinks;
    }

    public Map<String, String> getMetadata() { return metadata; }

    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

}
