package com.wildbit.java.postmark.client.data.model.server;

import java.util.List;

/**
 * Server object.
 */
public class Server {

    private Integer id;
    private String name;
    private List<String> apiTokens;
    private String serverLink;
    private String color;
    private Boolean smtpApiActivated;
    private Boolean rawEmailEnabled;
    private String deliveryHookUrl;
    private String inboundAddress;
    private String inboundHookUrl;
    private String bounceHookUrl;
    private Boolean includeBounceContentInHook;
    private String openHookUrl;
    private Boolean postFirstOpenOnly;
    private Boolean trackOpens;
    private String trackLinks;
    private String clickHookUrl;
    private String inboundDomain;
    private String inboundHash;
    private String inboundSpamThreshold;
    private String enableSmtpApiErrorHooks;

    // SETTERS AND GETTERS

    public String getEnableSmtpApiErrorHooks() { return enableSmtpApiErrorHooks; }

    public void setEnableSmtpApiErrorHooks(String enableSmtpApiErrorHooks) { this.enableSmtpApiErrorHooks = enableSmtpApiErrorHooks; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getApiTokens() {
        return apiTokens;
    }

    public void setApiTokens(List<String> apiTokens) {
        this.apiTokens = apiTokens;
    }

    public String getServerLink() {
        return serverLink;
    }

    public void setServerLink(String serverLink) {
        this.serverLink = serverLink;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isSmtpApiActivated() {
        return smtpApiActivated;
    }

    public void setSmtpApiActivated(Boolean smtpApiActivated) {
        this.smtpApiActivated = smtpApiActivated;
    }

    public Boolean isRawEmailEnabled() {
        return rawEmailEnabled;
    }

    public void setRawEmailEnabled(Boolean rawEmailEnabled) {
        this.rawEmailEnabled = rawEmailEnabled;
    }

    public String getDeliveryHookUrl() {
        return deliveryHookUrl;
    }

    public void setDeliveryHookUrl(String deliveryHookUrl) {
        this.deliveryHookUrl = deliveryHookUrl;
    }

    public String getInboundAddress() {
        return inboundAddress;
    }

    public void setInboundAddress(String inboundAddress) {
        this.inboundAddress = inboundAddress;
    }

    public String getInboundHookUrl() {
        return inboundHookUrl;
    }

    public void setInboundHookUrl(String inboundHookUrl) {
        this.inboundHookUrl = inboundHookUrl;
    }

    public String getBounceHookUrl() {
        return bounceHookUrl;
    }

    public void setBounceHookUrl(String bounceHookUrl) {
        this.bounceHookUrl = bounceHookUrl;
    }

    public Boolean isIncludeBounceContentInHook() {
        return includeBounceContentInHook;
    }

    public void setIncludeBounceContentInHook(Boolean includeBounceContentInHook) {
        this.includeBounceContentInHook = includeBounceContentInHook;
    }

    public String getOpenHookUrl() {
        return openHookUrl;
    }

    public void setOpenHookUrl(String openHookUrl) {
        this.openHookUrl = openHookUrl;
    }

    public Boolean isPostFirstOpenOnly() {
        return postFirstOpenOnly;
    }

    public void setPostFirstOpenOnly(Boolean postFirstOpenOnly) {
        this.postFirstOpenOnly = postFirstOpenOnly;
    }

    public Boolean isTrackOpens() {
        return trackOpens;
    }

    public void setTrackOpens(Boolean trackOpens) {
        this.trackOpens = trackOpens;
    }

    public String getTrackLinks() {
        return trackLinks;
    }

    public void setTrackLinks(String trackLinks) {
        this.trackLinks = trackLinks;
    }

    public String getClickHookUrl() {
        return clickHookUrl;
    }

    public void setClickHookUrl(String clickHookUrl) {
        this.clickHookUrl = clickHookUrl;
    }

    public String getInboundDomain() {
        return inboundDomain;
    }

    public void setInboundDomain(String inboundDomain) {
        this.inboundDomain = inboundDomain;
    }

    public String getInboundHash() {
        return inboundHash;
    }

    public void setInboundHash(String inboundHash) {
        this.inboundHash = inboundHash;
    }

    public String getInboundSpamThreshold() {
        return inboundSpamThreshold;
    }

    public void setInboundSpamThreshold(String inboundSpamThreshold) {
        this.inboundSpamThreshold = inboundSpamThreshold;
    }
}
