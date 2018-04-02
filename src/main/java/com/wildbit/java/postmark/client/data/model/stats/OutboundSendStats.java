package com.wildbit.java.postmark.client.data.model.stats;

import java.util.List;

/**
 * Sent stats object.
 */
public class OutboundSendStats {

    private Integer sent;
    private List<SentStat> days;

    // SETTERS AND GETTERS

    public List<SentStat> getDays() {
        return days;
    }
    public void setDays(List<SentStat> days) {
        this.days = days;
    }

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }
}


