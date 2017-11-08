package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Created by bash on 11/2/17.
 */
public class SpamStat extends  BaseStat {

    private Integer spamComplaint;

    public Integer getSpamComplaint() {
        return spamComplaint;
    }

    public void setSpamComplaint(Integer spamComplaint) {
        this.spamComplaint = spamComplaint;
    }
}
