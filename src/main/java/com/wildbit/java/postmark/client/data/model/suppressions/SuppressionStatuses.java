package com.wildbit.java.postmark.client.data.model.suppressions;

import java.util.List;

public class SuppressionStatuses {
    private List<SuppressionStatus> suppressions;

    public List<SuppressionStatus> getSuppressions() {
        return suppressions;
    }

    public void setSuppressions(List<SuppressionStatus> suppressions) {
        this.suppressions = suppressions;
    }
}
