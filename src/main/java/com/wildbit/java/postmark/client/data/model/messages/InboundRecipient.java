package com.wildbit.java.postmark.client.data.model.messages;

/**
 * Created by bash on 11/1/17.
 */
public class InboundRecipient extends Recipient{

    private String mailboxHash;

    public String getMailboxHash() {
        return mailboxHash;
    }

    public void setMailboxHash(String mailboxHash) {
        this.mailboxHash = mailboxHash;
    }
}
