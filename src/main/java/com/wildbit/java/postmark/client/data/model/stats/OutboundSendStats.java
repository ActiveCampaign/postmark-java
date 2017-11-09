package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;

/**
 * Sent stats POJO.
 */
public class OutboundSendStats {

    private Integer sent;
    private ArrayList<SentStat> days;

    // SETTERS AND GETTERS

    public ArrayList<SentStat> getDays() {
        return days;
    }
    public void setDays(ArrayList<SentStat> days) {
        this.days = days;
    }

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }
}


