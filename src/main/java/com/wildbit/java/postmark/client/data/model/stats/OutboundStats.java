package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Stats overall object.
 */
public class OutboundStats {

    private Integer sent;
    private Integer bounced;
    private Integer smtpApiErrors;
    private Integer bounceRate;
    private Integer spamComplaints;
    private Integer spamComplaintsRate;
    private Integer opens;
    private Integer uniqueOpens;
    private Integer tracked;
    private Integer withLinkTracking;
    private Integer withOpenTracking;
    private Integer totalTrackedLinksSent;
    private Integer uniqueLinksClicked;
    private Integer totalClicks;
    private Integer withClientRecorded;
    private Integer withPlatformRecorded;
    private Integer withReadTimeRecorded;

    // SETTERS AND GETTERS

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }

    public Integer getBounced() {
        return bounced;
    }

    public void setBounced(Integer bounced) {
        this.bounced = bounced;
    }

    public Integer getSmtpApiErrors() {
        return smtpApiErrors;
    }

    public void setSmtpApiErrors(Integer smtpApiErrors) {
        this.smtpApiErrors = smtpApiErrors;
    }

    public Integer getBounceRate() {
        return bounceRate;
    }

    public void setBounceRate(Integer bounceRate) {
        this.bounceRate = bounceRate;
    }

    public Integer getSpamComplaints() {
        return spamComplaints;
    }

    public void setSpamComplaints(Integer spamComplaints) {
        this.spamComplaints = spamComplaints;
    }

    public Integer getSpamComplaintsRate() {
        return spamComplaintsRate;
    }

    public void setSpamComplaintsRate(Integer spamComplaintsRate) {
        this.spamComplaintsRate = spamComplaintsRate;
    }

    public Integer getOpens() {
        return opens;
    }

    public void setOpens(Integer opens) {
        this.opens = opens;
    }

    public Integer getUniqueOpens() {
        return uniqueOpens;
    }

    public void setUniqueOpens(Integer uniqueOpens) {
        this.uniqueOpens = uniqueOpens;
    }

    public Integer getTracked() {
        return tracked;
    }

    public void setTracked(Integer tracked) {
        this.tracked = tracked;
    }

    public Integer getWithLinkTracking() {
        return withLinkTracking;
    }

    public void setWithLinkTracking(Integer withLinkTracking) {
        this.withLinkTracking = withLinkTracking;
    }

    public Integer getWithOpenTracking() {
        return withOpenTracking;
    }

    public void setWithOpenTracking(Integer withOpenTracking) {
        this.withOpenTracking = withOpenTracking;
    }

    public Integer getTotalTrackedLinksSent() {
        return totalTrackedLinksSent;
    }

    public void setTotalTrackedLinksSent(Integer totalTrackedLinksSent) {
        this.totalTrackedLinksSent = totalTrackedLinksSent;
    }

    public Integer getUniqueLinksClicked() {
        return uniqueLinksClicked;
    }

    public void setUniqueLinksClicked(Integer uniqueLinksClicked) {
        this.uniqueLinksClicked = uniqueLinksClicked;
    }

    public Integer getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(Integer totalClicks) {
        this.totalClicks = totalClicks;
    }

    public Integer getWithClientRecorded() {
        return withClientRecorded;
    }

    public void setWithClientRecorded(Integer withClientRecorded) {
        this.withClientRecorded = withClientRecorded;
    }

    public Integer getWithPlatformRecorded() {
        return withPlatformRecorded;
    }

    public void setWithPlatformRecorded(Integer withPlatformRecorded) {
        this.withPlatformRecorded = withPlatformRecorded;
    }

    public Integer getWithReadTimeRecorded() {
        return withReadTimeRecorded;
    }

    public void setWithReadTimeRecorded(Integer withReadTimeRecorded) {
        this.withReadTimeRecorded = withReadTimeRecorded;
    }
}
