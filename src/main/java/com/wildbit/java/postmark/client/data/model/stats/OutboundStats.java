package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Stats overall POJO.
 */
public class OutboundStats {

    private String sent;
    private String bounced;
    private String smtpApiErrors;
    private String bounceRate;
    private String spamComplaints;
    private String spamComplaintsRate;
    private String opens;
    private String uniqueOpens;
    private String tracked;
    private String withLinkTracking;
    private String withOpenTracking;
    private String totalTrackedLinksSent;
    private String uniqueLinksClicked;
    private String totalClicks;
    private String withClientRecorded;
    private String withPlatformRecorded;
    private String withReadTimeRecorded;

    // SETTERS AND GETTERS

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getBounced() {
        return bounced;
    }

    public void setBounced(String bounced) {
        this.bounced = bounced;
    }

    public String getSmtpApiErrors() {
        return smtpApiErrors;
    }

    public void setSmtpApiErrors(String smtpApiErrors) {
        this.smtpApiErrors = smtpApiErrors;
    }

    public String getBounceRate() {
        return bounceRate;
    }

    public void setBounceRate(String bounceRate) {
        this.bounceRate = bounceRate;
    }

    public String getSpamComplaints() {
        return spamComplaints;
    }

    public void setSpamComplaints(String spamComplaints) {
        this.spamComplaints = spamComplaints;
    }

    public String getSpamComplaintsRate() {
        return spamComplaintsRate;
    }

    public void setSpamComplaintsRate(String spamComplaintsRate) {
        this.spamComplaintsRate = spamComplaintsRate;
    }

    public String getOpens() {
        return opens;
    }

    public void setOpens(String opens) {
        this.opens = opens;
    }

    public String getUniqueOpens() {
        return uniqueOpens;
    }

    public void setUniqueOpens(String uniqueOpens) {
        this.uniqueOpens = uniqueOpens;
    }

    public String getTracked() {
        return tracked;
    }

    public void setTracked(String tracked) {
        this.tracked = tracked;
    }

    public String getWithLinkTracking() {
        return withLinkTracking;
    }

    public void setWithLinkTracking(String withLinkTracking) {
        this.withLinkTracking = withLinkTracking;
    }

    public String getWithOpenTracking() {
        return withOpenTracking;
    }

    public void setWithOpenTracking(String withOpenTracking) {
        this.withOpenTracking = withOpenTracking;
    }

    public String getTotalTrackedLinksSent() {
        return totalTrackedLinksSent;
    }

    public void setTotalTrackedLinksSent(String totalTrackedLinksSent) {
        this.totalTrackedLinksSent = totalTrackedLinksSent;
    }

    public String getUniqueLinksClicked() {
        return uniqueLinksClicked;
    }

    public void setUniqueLinksClicked(String uniqueLinksClicked) {
        this.uniqueLinksClicked = uniqueLinksClicked;
    }

    public String getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(String totalClicks) {
        this.totalClicks = totalClicks;
    }

    public String getWithClientRecorded() {
        return withClientRecorded;
    }

    public void setWithClientRecorded(String withClientRecorded) {
        this.withClientRecorded = withClientRecorded;
    }

    public String getWithPlatformRecorded() {
        return withPlatformRecorded;
    }

    public void setWithPlatformRecorded(String withPlatformRecorded) {
        this.withPlatformRecorded = withPlatformRecorded;
    }

    public String getWithReadTimeRecorded() {
        return withReadTimeRecorded;
    }

    public void setWithReadTimeRecorded(String withReadTimeRecorded) {
        this.withReadTimeRecorded = withReadTimeRecorded;
    }
}
