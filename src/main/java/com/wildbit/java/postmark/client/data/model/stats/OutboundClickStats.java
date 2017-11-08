package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;

/**
 * Created by bash on 11/2/17.
 */
public class OutboundClickStats {

    private ArrayList<ClickStat> days;
    private Integer clicks;
    private Integer unique;

    public ArrayList<ClickStat> getDays() {
        return days;
    }

    public void setDays(ArrayList<ClickStat> days) {
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
