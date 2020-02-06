package com.wildbit.java.postmark.client.data.model.suppressions;

import java.util.ArrayList;
import java.util.List;

public class SuppressionEntries {
    private List<SuppressionEntry> suppressions;

    public SuppressionEntries(String[] emailAddresses) {
        suppressions = new ArrayList<>();

        for(String emailAddress: emailAddresses) {
            suppressions.add(new SuppressionEntry(emailAddress));
        }
    }

    public List<SuppressionEntry> getSuppressions() {
        return suppressions;
    }

    public void setSuppressions(List<SuppressionEntry> suppressions) {
        this.suppressions = suppressions;
    }
}
