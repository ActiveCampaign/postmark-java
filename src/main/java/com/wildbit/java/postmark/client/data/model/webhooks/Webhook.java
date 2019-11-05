package com.wildbit.java.postmark.client.data.model.webhooks;

import com.wildbit.java.postmark.client.data.model.message.Header;

import java.util.ArrayList;
import java.util.List;

public class Webhook {
    private Integer id;
    private String url;
    private HttpAuth httpAuth;
    private List<Header> httpHeaders;
    private String messageStream;
    private WebhookTriggers triggers;

    public Webhook() {
    }

    public Webhook(String url) {
        this.url = url;
    }

    public Webhook(String url, WebhookTriggers triggers) {
        this.url = url;
        this.triggers = triggers;
    }

    public Webhook(String url, HttpAuth httpAuth, WebhookTriggers triggers) {
        this.url = url;
        this.triggers = triggers;
        this.httpAuth = httpAuth;
    }

    public Webhook(String url, HttpAuth httpAuth, WebhookTriggers triggers, List<Header> httpHeaders) {
        this.url = url;
        this.triggers = triggers;
        this.httpAuth = httpAuth;
        this.httpHeaders = httpHeaders;
    }

    public void addHeader(String name, String value) {
        if (this.httpHeaders == null) {
            setHttpHeaders(new ArrayList<>());
        }
        this.httpHeaders.add(new Header(name,value));
    }

    public void clearHeaders() {
        if (this.httpHeaders != null) {
            this.httpHeaders.clear();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpAuth getHttpAuth() {
        return httpAuth;
    }

    public void setHttpAuth(HttpAuth httpAuth) {
        this.httpAuth = httpAuth;
    }

    public List<Header> getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(List<Header> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public String getMessageStream() {
        return messageStream;
    }

    public void setMessageStream(String messageStream) {
        this.messageStream = messageStream;
    }

    public WebhookTriggers getTriggers() {
        return triggers;
    }

    public void setTriggers(WebhookTriggers triggers) {
        this.triggers = triggers;
    }
}

