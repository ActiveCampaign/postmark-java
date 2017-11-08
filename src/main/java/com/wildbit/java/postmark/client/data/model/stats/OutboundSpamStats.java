package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;

/**
 * Created by bash on 11/2/17.
 */
public class OutboundSpamStats {

    private ArrayList<SpamStat> days;
    private Integer spamComplaint;

    public ArrayList<SpamStat> getDays() {
        return days;
    }

    public void setDays(ArrayList<SpamStat> days) {
        this.days = days;
    }

    public Integer getSpamComplaint() {
        return spamComplaint;
    }

    public void setSpamComplaint(Integer spamComplaint) {
        this.spamComplaint = spamComplaint;
    }
}
