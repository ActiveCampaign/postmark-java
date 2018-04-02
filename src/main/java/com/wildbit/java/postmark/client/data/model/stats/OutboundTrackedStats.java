package com.wildbit.java.postmark.client.data.model.stats;

import java.util.List;

/**
 * Tracked stats object.
 */
public class OutboundTrackedStats {

    private List<TrackedStat> days;
    private Integer tracked;

    // SETTERS AND GETTERS

    public List<TrackedStat> getDays() {
        return days;
    }

    public void setDays(List<TrackedStat> days) {
        this.days = days;
    }

    public Integer getTracked() {
        return tracked;
    }

    public void setTracked(Integer tracked) {
        this.tracked = tracked;
    }
}
