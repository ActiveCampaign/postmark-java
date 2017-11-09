package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Bounce stat POJO.
 */
public class BounceStat extends BaseStat {

    private String hardBounce;
    private String softBounce;
    private String smtpApiError;
    private String spamComplaint;
    private String ispBlock;
    private String Transient;

    // SETTERS AND GETTERS

    public String getTransient() {
        return Transient;
    }

    public void setTransient(String aTransient) {
        Transient = aTransient;
    }

    public String getHardBounce() {
        return hardBounce;
    }

    public void setHardBounce(String hardBounce) {
        this.hardBounce = hardBounce;
    }

    public String getSoftBounce() {
        return softBounce;
    }

    public void setSoftBounce(String softBounce) {
        this.softBounce = softBounce;
    }

    public String getSmtpApiError() {
        return smtpApiError;
    }

    public void setSmtpApiError(String smtpApiError) {
        this.smtpApiError = smtpApiError;
    }

    public String getSpamComplaint() {
        return spamComplaint;
    }

    public void setSpamComplaint(String spamComplaint) {
        this.spamComplaint = spamComplaint;
    }

    public String getIspBlock() {
        return ispBlock;
    }

    public void setIspBlock(String ispBlock) {
        this.ispBlock = ispBlock;
    }
}
