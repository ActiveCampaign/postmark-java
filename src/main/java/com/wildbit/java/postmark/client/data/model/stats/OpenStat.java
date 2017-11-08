package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Created by bash on 11/2/17.
 */
public class OpenStat extends BaseStat {

    private Integer opens;
    private Integer unique;

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
