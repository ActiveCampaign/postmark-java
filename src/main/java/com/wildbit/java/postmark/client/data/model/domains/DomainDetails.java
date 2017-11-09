package com.wildbit.java.postmark.client.data.model.domains;

/**
 * Domain details object.
 */
public class DomainDetails extends Domain {

    private String spfHost;
    private String spfTextValue;
    private String dkimHost;
    private String dkimTextValue;
    private String dkimPendingHost;
    private String dkimPendingTextValue;
    private String dkimRevokedHost;
    private String dkimRevokedTextValue;
    private String safeToRemoveRevokedKeyFromDNS;
    private String dkimUpdateStatus;
    private String returnPathDomain;
    private String returnPathDomainCNAMEValue;

    // GETTERS AND SETTERS

    public String getSpfHost() {
        return spfHost;
    }

    public void setSpfHost(String spfHost) {
        this.spfHost = spfHost;
    }

    public String getSpfTextValue() {
        return spfTextValue;
    }

    public void setSpfTextValue(String spfTextValue) {
        this.spfTextValue = spfTextValue;
    }

    public String getDkimHost() {
        return dkimHost;
    }

    public void setDkimHost(String dkimHost) {
        this.dkimHost = dkimHost;
    }

    public String getDkimTextValue() {
        return dkimTextValue;
    }

    public void setDkimTextValue(String dkimTextValue) {
        this.dkimTextValue = dkimTextValue;
    }

    public String getDkimPendingHost() {
        return dkimPendingHost;
    }

    public void setDkimPendingHost(String dkimPendingHost) {
        this.dkimPendingHost = dkimPendingHost;
    }

    public String getDkimPendingTextValue() {
        return dkimPendingTextValue;
    }

    public void setDkimPendingTextValue(String dkimPendingTextValue) {
        this.dkimPendingTextValue = dkimPendingTextValue;
    }

    public String getDkimRevokedHost() {
        return dkimRevokedHost;
    }

    public void setDkimRevokedHost(String dkimRevokedHost) {
        this.dkimRevokedHost = dkimRevokedHost;
    }

    public String getDkimRevokedTextValue() {
        return dkimRevokedTextValue;
    }

    public void setDkimRevokedTextValue(String dkimRevokedTextValue) {
        this.dkimRevokedTextValue = dkimRevokedTextValue;
    }

    public String getSafeToRemoveRevokedKeyFromDNS() {
        return safeToRemoveRevokedKeyFromDNS;
    }

    public void setSafeToRemoveRevokedKeyFromDNS(String safeToRemoveRevokedKeyFromDNS) {
        this.safeToRemoveRevokedKeyFromDNS = safeToRemoveRevokedKeyFromDNS;
    }

    public String getDkimUpdateStatus() {
        return dkimUpdateStatus;
    }

    public void setDkimUpdateStatus(String dkimUpdateStatus) {
        this.dkimUpdateStatus = dkimUpdateStatus;
    }

    public String getReturnPathDomain() {
        return returnPathDomain;
    }

    public void setReturnPathDomain(String returnPathDomain) {
        this.returnPathDomain = returnPathDomain;
    }

    public String getReturnPathDomainCNAMEValue() {
        return returnPathDomainCNAMEValue;
    }

    public void setReturnPathDomainCNAMEValue(String returnPathDomainCNAMEValue) {
        this.returnPathDomainCNAMEValue = returnPathDomainCNAMEValue;
    }

}
