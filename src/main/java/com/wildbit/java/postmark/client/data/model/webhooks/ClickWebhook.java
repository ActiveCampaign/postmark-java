package com.wildbit.java.postmark.client.data.model.webhooks;

import com.wildbit.java.postmark.client.data.model.messages.OutboundMessageClick;

import java.util.HashMap;
import java.util.List;

/**
 * Click webhook object.
 */
public class ClickWebhook extends OutboundMessageClick {

    private List<HashMap<String, String>> metadata;

    // GETTERS AND SETTERS

    public List<HashMap<String, String>> getMetadata() { return metadata; }

    public void setMetadata(List<HashMap<String, String>> metadata) { this.metadata = metadata; }
}
