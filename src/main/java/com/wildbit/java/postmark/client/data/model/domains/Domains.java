package com.wildbit.java.postmark.client.data.model.domains;

import java.util.ArrayList;

/**
 * Domains object.
 */
public class Domains {

    private Integer totalCount;
    private ArrayList<Domain> domains;

    // GETTERS AND SETTERS

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
}
