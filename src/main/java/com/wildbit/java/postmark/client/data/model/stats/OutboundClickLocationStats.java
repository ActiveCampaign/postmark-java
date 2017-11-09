package com.wildbit.java.postmark.client.data.model.stats;

import java.util.ArrayList;

/**
 * Click location stat POJO.
 */
public class OutboundClickLocationStats {

    private Integer html;
    private Integer htmlAndText;
    private Integer text;
    private ArrayList<ClickLocationStat> days;

    // SETTERS AND GETTERS

    public Integer getHtml() {
        return html;
    }

    public void setHtml(Integer html) {
        this.html = html;
    }

    public Integer getHtmlAndText() {
        return htmlAndText;
    }

    public void setHtmlAndText(Integer htmlAndText) {
        this.htmlAndText = htmlAndText;
    }

    public Integer getText() {
        return text;
    }

    public void setText(Integer text) {
        this.text = text;
    }

    public ArrayList<ClickLocationStat> getDays() {
        return days;
    }

    public void setDays(ArrayList<ClickLocationStat> days) {
        this.days = days;
    }
}
