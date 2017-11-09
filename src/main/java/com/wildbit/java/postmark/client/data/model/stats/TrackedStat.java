package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Tracked stats object.
 */
public class TrackedStat extends BaseStat{

    private Integer tracked;

    // SETTERS AND GETTERS

    public Integer getTracked() {
        return tracked;
    }

    public void setTracked(Integer tracked) {
        this.tracked = tracked;
    }
}
