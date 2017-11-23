package com.wildbit.java.postmark.client.data.model.messages;

import java.util.ArrayList;
import java.util.Date;

/**
 * Outbound message object.
 */
public class OutboundMessage {

    private String tag;
    private String messageId;
    private ArrayList<Recipient> to;
    private ArrayList<Recipient> cc;
    private ArrayList<Recipient> bcc;
    private ArrayList<String> recipients;
    private Date receivedAt;
    private String from;
    private String subject;
    private ArrayList<String> attachments;
    private String status;
    private Boolean trackOpens;
    private String trackLinks;

    // GETTERS AND SETTERS

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

    public ArrayList<Recipient> getTo() {
        return to;
    }

    public void setTo(ArrayList<Recipient> to) {
        this.to = to;
    }

    public ArrayList<Recipient> getCc() {
        return cc;
    }

    public void setCc(ArrayList<Recipient> cc) {
        this.cc = cc;
    }

    public ArrayList<Recipient> getBcc() {
        return bcc;
    }

    public void setBcc(ArrayList<Recipient> bcc) {
        this.bcc = bcc;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<String> recipients) {
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

    public ArrayList<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<String> attachments) {
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

}
