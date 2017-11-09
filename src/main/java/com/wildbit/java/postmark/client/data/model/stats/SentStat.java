package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Sent stats object.
 */
public class SentStat extends BaseStat {

    private Integer sent;

    // SETTERS AND GETTERS

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }
}
