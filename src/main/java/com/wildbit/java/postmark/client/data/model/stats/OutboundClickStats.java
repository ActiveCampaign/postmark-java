package com.wildbit.java.postmark.client.data.model.stats;

import java.util.List;

/**
 * Clicks stats object.
 */
public class OutboundClickStats {

    private List<ClickStat> days;
    private Integer clicks;
    private Integer unique;

    // SETTERS AND GETTERS

    public List<ClickStat> getDays() {
        return days;
    }

    public void setDays(List<ClickStat> days) {
        this.days = days;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getUnique() {
        return unique;
    }

    public void setUnique(Integer unique) {
        this.unique = unique;
    }
}
