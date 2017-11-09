package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Open stat object.
 */
public class OpenStat extends BaseStat {

    private Integer opens;
    private Integer unique;

    // SETTERS AND GETTERS

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
