package com.wildbit.java.postmark.client.data.model.stats;

/**
 * Click location object.
 */
public class ClickLocationStat extends BaseStat {

    private Integer html;
    private Integer htmlAndText;
    private Integer text;

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
}
