package com.wildbit.java.postmark.client.data.model.triggers;

import java.util.ArrayList;

/**
 * Tag matchers object.
 */
public class TagMatchers {

    private Integer totalCount;
    private ArrayList<TagMatcher> tags;

    // SETTERS AND GETTERS

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
