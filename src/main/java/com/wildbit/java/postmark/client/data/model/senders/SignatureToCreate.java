package com.wildbit.java.postmark.client.data.model.senders;

/**
 * Signature to create object.
 */
public class SignatureToCreate {

    private String fromEmail;
    private String name;
    private String replyToEmail;
    private String returnPathDOmain;

    // SETTERS AND GETTERS

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReplyToEmail() {
        return replyToEmail;
    }

    public void setReplyToEmail(String replyToEmail) {
        this.replyToEmail = replyToEmail;
    }

    public String getReturnPathDOmain() {
        return returnPathDOmain;
    }

    public void setReturnPathDOmain(String returnPathDOmain) {
        this.returnPathDOmain = returnPathDOmain;
    }
}
