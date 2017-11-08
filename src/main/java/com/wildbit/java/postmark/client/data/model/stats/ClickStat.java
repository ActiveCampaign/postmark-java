package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Created by bash on 11/2/17.
 */
public class ClickStat extends BaseStat {

    private Integer clicks;
    private Integer unique;

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
