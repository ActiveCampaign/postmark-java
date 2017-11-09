package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;

/**
 * Open stats object.
 */
public class OutboundOpenStats {

    private ArrayList<OpenStat> days;
    private Integer opens;
    private Integer unique;

    // SETTERS AND GETTERS

    public ArrayList<OpenStat> getDays() {
        return days;
    }

    public void setDays(ArrayList<OpenStat> days) {
        this.days = days;
    }

    public Integer getOpens() {
        return opens;
    }

    public void setOpens(Integer opens) {
        this.opens = opens;
    }

    public Integer getUnique() {
        return unique;
    }

    public void setUnique(Integer unique) {
        this.unique = unique;
    }
}
