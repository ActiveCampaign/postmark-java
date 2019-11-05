package com.wildbit.java.postmark.client.data.model.webhooks;

public class HttpAuth {
    private String username;
    private String password;

    public HttpAuth() {
    }

    public HttpAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
