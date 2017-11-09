package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Open platform stat object.
 */
public class OpenPlatformStat extends BaseStat {

    private Integer desktop;
    private Integer mobile;
    private Integer webmail;
    private Integer unknown;

    // SETTERS AND GETTERS

    public Integer getDesktop() {
        return desktop;
    }

    public void setDesktop(Integer desktop) {
        this.desktop = desktop;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Integer getWebmail() {
        return webmail;
    }

    public void setWebmail(Integer webmail) {
        this.webmail = webmail;
    }

    public Integer getUnknown() {
        return unknown;
    }

    public void setUnknown(Integer unknown) {
        this.unknown = unknown;
    }
}
