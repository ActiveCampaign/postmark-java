package com.wildbit.java.postmark.client.data.model.bounces;

import java.util.ArrayList;

/**
 * Bounces POJO
 */
public class Bounces {

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

    private int totalCount;
    private ArrayList<Bounce> bounces;
}
