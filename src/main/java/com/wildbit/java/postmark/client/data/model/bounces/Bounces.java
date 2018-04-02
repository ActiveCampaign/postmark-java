package com.wildbit.java.postmark.client.data.model.bounces;

import java.util.List;

/**
 * Bounces object
 */
public class Bounces {

    private int totalCount;
    private List<Bounce> bounces;

    // SETTERS AND GETTERS

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Bounce> getBounces() {
        return bounces;
    }

    public void setBounces(List<Bounce> bounces) {
        this.bounces = bounces;
    }
}
