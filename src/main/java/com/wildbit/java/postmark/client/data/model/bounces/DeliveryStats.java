package com.wildbit.java.postmark.client.data.model.bounces;

import java.util.List;

/**
 * Delivery Stats object
 */
public class DeliveryStats {

    private int inactiveMails;
    private List<BounceType> bounces;

    // SETTERS AND GETTERS

    public int getInactiveMails() {
        return inactiveMails;
    }

    public void setInactiveMails(int inactiveMails) {
        this.inactiveMails = inactiveMails;
    }

    public List<BounceType> getBounces() {
        return bounces;
    }

    public void setBounces(List<BounceType> bounces) {
        this.bounces = bounces;
    }
}
