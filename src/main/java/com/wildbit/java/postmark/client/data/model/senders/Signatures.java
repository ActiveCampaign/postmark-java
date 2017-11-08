package com.wildbit.java.postmark.client.data.model.senders;

import java.util.ArrayList;

/**
 * Created by bash on 11/2/17.
 */
public class Signatures {

    private ArrayList<Signature> senderSignatures;
    private Integer totalCount;

    public ArrayList<Signature> getSenderSignatures() {
        return senderSignatures;
    }

    public void setSenderSignatures(ArrayList<Signature> senderSignatures) {
        this.senderSignatures = senderSignatures;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
