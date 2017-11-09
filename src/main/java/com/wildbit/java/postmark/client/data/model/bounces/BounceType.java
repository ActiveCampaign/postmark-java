package com.wildbit.java.postmark.client.data.model.bounces;

/**
 * Bounce Types object
 */
public class BounceType {

    private String name;
    private Integer count;
    private String type;

    // SETTERS AND GETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
