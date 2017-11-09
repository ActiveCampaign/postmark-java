package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Spam stats object.
 */
public class SpamStat extends  BaseStat {

    private Integer spamComplaint;

    // SETTERS AND GETTERS

    public Integer getSpamComplaint() {
        return spamComplaint;
    }

    public void setSpamComplaint(Integer spamComplaint) {
        this.spamComplaint = spamComplaint;
    }
}
