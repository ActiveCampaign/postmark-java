package com.wildbit.java.postmark.client.data.model.stats;

import java.util.List;

/**
 * Spam stats object.
 */
public class OutboundSpamStats {

    private List<SpamStat> days;
    private Integer spamComplaint;

    // SETTERS AND GETTERS

    public List<SpamStat> getDays() {
        return days;
    }

    public void setDays(List<SpamStat> days) {
        this.days = days;
    }

    public Integer getSpamComplaint() {
        return spamComplaint;
    }

    public void setSpamComplaint(Integer spamComplaint) {
        this.spamComplaint = spamComplaint;
    }
}
