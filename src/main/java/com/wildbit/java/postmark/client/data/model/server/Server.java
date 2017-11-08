package com.wildbit.java.postmark.client.data.model.server;

import java.util.ArrayList;

/**
 * Created by bash on 11/1/17.
 */
public class Server {

    private int id;
    private String name;
    private ArrayList<String> apiTokens;
    private String serverLink;
    private String color;
    private boolean smtpApiActivated;
    private boolean rawEmailEnabled;
    private String deliveryHookUrl;
    private String inboundAddress;
    private String inboundHookUrl;
    private String bounceHookUrl;
    private boolean includeBounceContentInHook;
    private String openHookUrl;
    private boolean postFirstOpenOnly;
    private boolean trackOpens;
    private String trackLinks;
    private String clickHookUrl;
    private String inboundDomain;
    private String inboundHash;
    private String inboundSpamThreshold;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getApiTokens() {
        return apiTokens;
    }

    public void setApiTokens(ArrayList<String> apiTokens) {
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

    public boolean isSmtpApiActivated() {
        return smtpApiActivated;
    }

    public void setSmtpApiActivated(boolean smtpApiActivated) {
        this.smtpApiActivated = smtpApiActivated;
    }

    public boolean isRawEmailEnabled() {
        return rawEmailEnabled;
    }

    public void setRawEmailEnabled(boolean rawEmailEnabled) {
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

    public boolean isIncludeBounceContentInHook() {
        return includeBounceContentInHook;
    }

    public void setIncludeBounceContentInHook(boolean includeBounceContentInHook) {
        this.includeBounceContentInHook = includeBounceContentInHook;
    }

    public String getOpenHookUrl() {
        return openHookUrl;
    }

    public void setOpenHookUrl(String openHookUrl) {
        this.openHookUrl = openHookUrl;
    }

    public boolean isPostFirstOpenOnly() {
        return postFirstOpenOnly;
    }

    public void setPostFirstOpenOnly(boolean postFirstOpenOnly) {
        this.postFirstOpenOnly = postFirstOpenOnly;
    }

    public boolean isTrackOpens() {
        return trackOpens;
    }

    public void setTrackOpens(boolean trackOpens) {
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
