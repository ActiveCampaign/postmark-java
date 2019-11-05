package com.wildbit.java.postmark.client.data.model.webhooks.sent_payload;

import com.wildbit.java.postmark.client.data.model.bounces.Bounce;

import java.util.HashMap;

/**
 * Bounce webhook object.
 */
public class BounceWebhook extends Bounce {

    private HashMap<String, String> metadata;

    // GETTERS AND SETTERS

    public HashMap<String, String> getMetadata() { return metadata; }

    public void setMetadata(HashMap<String, String> metadata) { this.metadata = metadata; }
}
