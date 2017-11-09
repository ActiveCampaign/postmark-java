package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Click stat object.
 */
public class ClickStat extends BaseStat {

    private Integer clicks;
    private Integer unique;

    // SETTERS AND GETTERS

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
