package com.wildbit.java.postmark.client.data.model.message;
import java.util.Date;

/**
 * HTTP send request response object
 */
public class MessageResponse extends BaseMessageResponse {
    private String to;
    private String cc;
    private String bcc;
    private Date submittedAt;
    private String messageId;

    // SETTERS AND GETTERS

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

}
