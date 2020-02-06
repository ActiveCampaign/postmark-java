package com.wildbit.java.postmark.client.data.model.suppressions;

import java.util.List;

public class Suppressions {
    private List<Suppression> suppressions;

    public List<Suppression> getSuppressions() {
        return suppressions;
    }

    public void setSuppressions(List<Suppression> suppressions) {
        this.suppressions = suppressions;
    }
}
