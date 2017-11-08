package com.wildbit.java.postmark.client.data.model.messages;

/**
 * Created by bash on 11/1/17.
 */
public class Recipient {
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

    private String name;
    private String email;
}
