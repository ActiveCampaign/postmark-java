package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Open clients stats POJO.
 */
public class OutboundOpenClientStats {

    private ArrayList<HashMap<String,String>> days;

    // SETTERS AND GETTERS

    public ArrayList<HashMap<String, String>> getDays() {
        return days;
    }

    public void setDays(ArrayList<HashMap<String, String>> days) {
        this.days = days;
    }


}
