package com.wildbit.java.postmark.client.data.model.senders;

import java.util.List;

/**
 * Signatures object.
 */
public class Signatures {

    private List<Signature> senderSignatures;
    private Integer totalCount;

    // SETTERS AND GETTERS

    public List<Signature> getSenderSignatures() {
        return senderSignatures;
    }

    public void setSenderSignatures(List<Signature> senderSignatures) {
        this.senderSignatures = senderSignatures;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
