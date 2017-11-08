package com.wildbit.java.postmark.client.data.model.bounces;

import java.util.ArrayList;

/**
 * Delivery Stats POJO
 */
public class DeliveryStats {

    public int getInactiveMails() {
        return inactiveMails;
    }

    public void setInactiveMails(int inactiveMails) {
        this.inactiveMails = inactiveMails;
    }

    public ArrayList<BounceTypes> getBounces() {
        return bounces;
    }

    public void setBounces(ArrayList<BounceTypes> bounces) {
        this.bounces = bounces;
    }

    private int inactiveMails;
    private ArrayList<BounceTypes> bounces;
}
