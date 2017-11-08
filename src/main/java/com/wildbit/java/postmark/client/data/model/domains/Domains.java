package com.wildbit.java.postmark.client.data.model.domains;

import java.util.ArrayList;

/**
 * Created by bash on 11/1/17.
 */
public class Domains {

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<Domain> getDomains() {
        return domains;
    }

    public void setDomains(ArrayList<Domain> domains) {
        this.domains = domains;
    }

    private Integer totalCount;
    private ArrayList<Domain> domains;
}
