package com.wildbit.java.postmark.client.data.model.bounces;

import java.util.ArrayList;

/**
 * Delivery Stats object
 */
public class DeliveryStats {

    private int inactiveMails;
    private ArrayList<BounceType> bounces;

    // SETTERS AND GETTERS

    public int getInactiveMails() {
        return inactiveMails;
    }

    public void setInactiveMails(int inactiveMails) {
        this.inactiveMails = inactiveMails;
    }

    public ArrayList<BounceType> getBounces() {
        return bounces;
    }

    public void setBounces(ArrayList<BounceType> bounces) {
        this.bounces = bounces;
    }
}
