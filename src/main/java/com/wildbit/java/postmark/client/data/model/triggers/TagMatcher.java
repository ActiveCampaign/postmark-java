package com.wildbit.java.postmark.client.data.model.triggers;

/**
 * Created by bash on 11/7/17.
 */
public class TagMatcher {

    private Integer id;
    private String matchName;
    private Boolean trackOpens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Boolean getTrackOpens() {
        return trackOpens;
    }

    public void setTrackOpens(Boolean trackOpens) {
        this.trackOpens = trackOpens;
    }
}
