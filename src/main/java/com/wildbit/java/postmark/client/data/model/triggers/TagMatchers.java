package com.wildbit.java.postmark.client.data.model.triggers;

import java.util.ArrayList;

/**
 * Created by bash on 11/7/17.
 */
public class TagMatchers {

    private Integer totalCount;
    private ArrayList<TagMatcher> tags;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<TagMatcher> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagMatcher> tags) {
        this.tags = tags;
    }
}
