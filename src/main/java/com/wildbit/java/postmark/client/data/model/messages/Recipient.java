package com.wildbit.java.postmark.client.data.model.messages;

/**
 * Recipient object.
 */
public class Recipient {

    private String name;
    private String email;

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
