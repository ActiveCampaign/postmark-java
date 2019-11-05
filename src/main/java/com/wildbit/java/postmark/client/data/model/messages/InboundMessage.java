package com.wildbit.java.postmark.client.data.model.messages;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wildbit.java.postmark.client.jackson.CustomDateDeserializer;

import java.util.List;
import java.util.Date;

/**
 * Inbound message object.
 */
public class InboundMessage {

    private String from;
    private String fromName;
    private InboundRecipient fromFull;
    private String to;
    private List<InboundRecipient> toFull;
    private String cc;
    private List<InboundRecipient> ccFull;
    private String bcc;
    private List<InboundRecipient> bccFull;
    private String replyTo;
    private String originalRecipient;
    private String subject;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;
    private String mailboxHash;
    private String tag;
    private String messageId;
    private String status;
    private List<Attachment> attachments;
    private String messageStream;

    // GETTERS AND SETTERS

    public String getMessageStream() {
        return messageStream;
    }

    public void setMessageStream(String messageStream) {
        this.messageStream = messageStream;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public InboundRecipient getFromFull() {
        return fromFull;
    }

    public void setFromFull(InboundRecipient fromFull) {
        this.fromFull = fromFull;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<InboundRecipient> getToFull() {
        return toFull;
    }

    public void setToFull(List<InboundRecipient> toFull) {
        this.toFull = toFull;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public List<InboundRecipient> getCcFull() {
        return ccFull;
    }

    public void setCcFull(List<InboundRecipient> ccFull) {
        this.ccFull = ccFull;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public List<InboundRecipient> getBccFull() {
        return bccFull;
    }

    public void setBccFull(List<InboundRecipient> bccFull) {
        this.bccFull = bccFull;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getOriginalRecipient() {
        return originalRecipient;
    }

    public void setOriginalRecipient(String originalRecipient) {
        this.originalRecipient = originalRecipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMailboxHash() {
        return mailboxHash;
    }

    public void setMailboxHash(String mailboxHash) {
        this.mailboxHash = mailboxHash;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
