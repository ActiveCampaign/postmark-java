package com.wildbit.java.postmark.client.data.model.stats;

import java.util.List;

/**
 * Click location stat object.
 */
public class OutboundClickLocationStats {

    private Integer html;
    private Integer htmlAndText;
    private Integer text;
    private List<ClickLocationStat> days;

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

    public List<ClickLocationStat> getDays() {
        return days;
    }

    public void setDays(List<ClickLocationStat> days) {
        this.days = days;
    }
}
