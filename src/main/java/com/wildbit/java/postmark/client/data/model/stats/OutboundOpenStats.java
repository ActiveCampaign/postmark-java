package com.wildbit.java.postmark.client.data.model.stats;

import java.util.List;

/**
 * Open stats object.
 */
public class OutboundOpenStats {

    private List<OpenStat> days;
    private Integer opens;
    private Integer unique;

    // SETTERS AND GETTERS

    public List<OpenStat> getDays() {
        return days;
    }

    public void setDays(List<OpenStat> days) {
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
