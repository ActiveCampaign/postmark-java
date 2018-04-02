package com.wildbit.java.postmark.client.data.model.triggers;

import java.util.List;

/**
 * Tag matchers object.
 */
public class TagMatchers {

    private Integer totalCount;
    private List<TagMatcher> tags;

    // SETTERS AND GETTERS

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<TagMatcher> getTags() {
        return tags;
    }

    public void setTags(List<TagMatcher> tags) {
        this.tags = tags;
    }
}
