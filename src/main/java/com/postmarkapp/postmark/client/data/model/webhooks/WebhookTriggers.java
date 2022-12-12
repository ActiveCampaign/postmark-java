package com.postmarkapp.postmark.client.data.model.webhooks;

import com.postmarkapp.postmark.client.data.model.webhooks.triggers.*;

public class WebhookTriggers {
    private OpenWebhookTrigger open;
    private WebhookTrigger click;
    private WebhookTrigger delivery;
    private BounceWebhookTrigger bounce;
    private SpamWebhookTrigger spamComplaint;

    private SubscriptionChange subscriptionChange;

    public WebhookTriggers() {
        this.open = new OpenWebhookTrigger(false);
        this.click = new WebhookTrigger(false);
        this.delivery = new WebhookTrigger(false);
        this.bounce = new BounceWebhookTrigger(false);
        this.spamComplaint = new SpamWebhookTrigger(false);
        this.subscriptionChange = new SubscriptionChange(false);
    }

    public WebhookTriggers(boolean openEnabled, boolean clickEnabled) {
        this.open = new OpenWebhookTrigger(openEnabled);
        this.click = new WebhookTrigger(clickEnabled);
    }

    public WebhookTriggers(boolean openEnabled, boolean clickEnabled,
                           boolean bounceEnabled) {
        this.open = new OpenWebhookTrigger(openEnabled);
        this.click = new WebhookTrigger(clickEnabled);
        this.bounce = new BounceWebhookTrigger(bounceEnabled);
    }

    public WebhookTriggers(boolean openEnabled, boolean clickEnabled,
                           boolean bounceEnabled, boolean spamComplaintEnabled, boolean deliveryEnabled) {
        this.open = new OpenWebhookTrigger(openEnabled);
        this.click = new WebhookTrigger(clickEnabled);
        this.delivery = new WebhookTrigger(deliveryEnabled);
        this.bounce = new BounceWebhookTrigger(bounceEnabled);
        this.spamComplaint = new SpamWebhookTrigger(spamComplaintEnabled);
    }

    public WebhookTriggers(boolean openEnabled, boolean clickEnabled,
                           boolean bounceEnabled, boolean spamComplaintEnabled, boolean deliveryEnabled,
                           boolean subscriptionChangeEnabled) {
        this.open = new OpenWebhookTrigger(openEnabled);
        this.click = new WebhookTrigger(clickEnabled);
        this.delivery = new WebhookTrigger(deliveryEnabled);
        this.bounce = new BounceWebhookTrigger(bounceEnabled);
        this.spamComplaint = new SpamWebhookTrigger(spamComplaintEnabled);
        this.subscriptionChange = new SubscriptionChange(subscriptionChangeEnabled);
    }

    public WebhookTriggers(OpenWebhookTrigger open, WebhookTrigger click, WebhookTrigger delivery,
                           BounceWebhookTrigger bounce, SpamWebhookTrigger spamComplaint) {
        this.open = open;
        this.click = click;
        this.delivery = delivery;
        this.bounce = bounce;
        this.spamComplaint = spamComplaint;
    }

    public WebhookTriggers(OpenWebhookTrigger open, WebhookTrigger click, WebhookTrigger delivery,
                           BounceWebhookTrigger bounce, SpamWebhookTrigger spamComplaint,
                           SubscriptionChange subscriptionChange) {
        this.open = open;
        this.click = click;
        this.delivery = delivery;
        this.bounce = bounce;
        this.spamComplaint = spamComplaint;
        this.subscriptionChange = subscriptionChange;
    }

    public OpenWebhookTrigger getOpen() {
        return open;
    }

    public void setOpen(OpenWebhookTrigger open) {
        this.open = open;
    }

    public WebhookTrigger getClick() {
        return click;
    }

    public void setClick(WebhookTrigger click) {
        this.click = click;
    }

    public WebhookTrigger getDelivery() {
        return delivery;
    }

    public void setDelivery(WebhookTrigger delivery) {
        this.delivery = delivery;
    }

    public BounceWebhookTrigger getBounce() {
        return bounce;
    }

    public void setBounce(BounceWebhookTrigger bounce) {
        this.bounce = bounce;
    }

    public SpamWebhookTrigger getSpamComplaint() {
        return spamComplaint;
    }

    public void setSpamComplaint(SpamWebhookTrigger spamComplaint) {
        this.spamComplaint = spamComplaint;
    }

    public SubscriptionChange getSubscriptionChange() {
        return subscriptionChange;
    }

    public void setSubscriptionChange(SubscriptionChange subscriptionChange) {
        this.subscriptionChange = subscriptionChange;
    }
}
