package com.wildbit.java.postmark.client.data.model.domains;

/**
 * Domain object.
 */
public class Domain {

    private String name;
    private Boolean spfVerified;
    private Boolean dkimVerified;
    private Boolean weakDKIM;
    private Boolean returnPathDomainVerified;
    private Integer id;

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSpfVerified() {
        return spfVerified;
    }

    public void setSpfVerified(Boolean spfVerified) {
        this.spfVerified = spfVerified;
    }

    public Boolean getDkimVerified() {
        return dkimVerified;
    }

    public void setDkimVerified(Boolean dkimVerified) {
        this.dkimVerified = dkimVerified;
    }

    public Boolean getWeakDKIM() {
        return weakDKIM;
    }

    public void setWeakDKIM(Boolean weakDKIM) {
        this.weakDKIM = weakDKIM;
    }

    public Boolean getReturnPathDomainVerified() {
        return returnPathDomainVerified;
    }

    public void setReturnPathDomainVerified(Boolean returnPathDomainVerified) {
        this.returnPathDomainVerified = returnPathDomainVerified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
