package com.wildbit.java.postmark.client.data.model.bounces;

import java.util.ArrayList;

/**
 * Bounces object
 */
public class Bounces {

    private int totalCount;
    private ArrayList<Bounce> bounces;

    // SETTERS AND GETTERS

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<Bounce> getBounces() {
        return bounces;
    }

    public void setBounces(ArrayList<Bounce> bounces) {
        this.bounces = bounces;
    }
}
