package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bash on 11/2/17.
 */
public class OutboundOpenClientStats {

    private ArrayList<HashMap<String,String>> days;

    public ArrayList<HashMap<String, String>> getDays() {
        return days;
    }

    public void setDays(ArrayList<HashMap<String, String>> days) {
        this.days = days;
    }
}
