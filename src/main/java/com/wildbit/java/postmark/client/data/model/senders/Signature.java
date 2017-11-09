package com.wildbit.java.postmark.client.data.model.senders;

/**
 * Signatre object.
 */
public class Signature {

    private String domain;
    private String emailAddress;
    private String replyToEmailAddress;
    private String name;
    private Boolean confirmed;
    private Integer id;

    // GETTERS AND SETTERS

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getReplyToEmailAddress() {
        return replyToEmailAddress;
    }

    public void setReplyToEmailAddress(String replyToEmailAddress) {
        this.replyToEmailAddress = replyToEmailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
