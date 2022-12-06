package com.postmarkapp.postmark.client.data.model.messages;

/**
 * Inbound recipient object
 */
public class InboundRecipient extends Recipient {

    private String mailboxHash;

    // GETTERS AND SETTERS

    public String getMailboxHash() {
        return mailboxHash;
    }

    public void setMailboxHash(String mailboxHash) {
        this.mailboxHash = mailboxHash;
    }
}
