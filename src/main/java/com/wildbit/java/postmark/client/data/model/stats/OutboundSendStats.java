package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;

/**
 * Created by bash on 11/2/17.
 */
public class OutboundSendStats {

    private Integer sent;
    private ArrayList<SentStat> days;

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


