package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;

/**
 * Tracked stats POJO.
 */
public class OutboundTrackedStats {

    private ArrayList<TrackedStat> days;
    private Integer tracked;

    // SETTERS AND GETTERS

    public ArrayList<TrackedStat> getDays() {
        return days;
    }

    public void setDays(ArrayList<TrackedStat> days) {
        this.days = days;
    }

    public Integer getTracked() {
        return tracked;
    }

    public void setTracked(Integer tracked) {
        this.tracked = tracked;
    }
}
