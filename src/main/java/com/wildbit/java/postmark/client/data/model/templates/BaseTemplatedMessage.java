package com.wildbit.java.postmark.client.data.model.templates;

import eu.medsea.mimeutil.MimeUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by bash on 10/14/17.
 */
public class BaseTemplatedMessage {
    private Integer templateId;
    private Object templateModel;
    private Boolean inlineCss;
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String replyTo;
    private String tag;
    private HashMap<String, String> headers;
    private ArrayList<HashMap<String, String>> attachments;

    public BaseTemplatedMessage() {
        this.setInlineCss(false);
    }

    public BaseTemplatedMessage(String from, String to) {
        this();
        this.from = from;
        this.to = to;
        this.attachments = new ArrayList<>();
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Object getTemplateModel() {
        return templateModel;
    }

    public void setTemplateModel(Object templateModel) {
        this.templateModel = templateModel;
    }

    public Boolean getInlineCss() {
        return inlineCss;
    }

    public void setInlineCss(Boolean inlineCss) {
        this.inlineCss = inlineCss;
    }

    public ArrayList<HashMap<String, String>> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<HashMap<String, String>> attachments) {
        this.attachments = attachments;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Helper method for setting recipients with email address and their Full Name.
     *
     * @param to recipients list
     * @see #convertRecipients(HashMap) for details
     */
    public void setTo(HashMap<String,String> to) {
        this.to = convertRecipients(to);
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * Helper method for setting recipients with email address and their Full Name.
     *
     * @param cc recipients list
     * @see #convertRecipients(HashMap) for details
     */
    public void setCc(HashMap<String,String> cc) {
        this.cc = convertRecipients(cc);
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     * Helper method for setting recipients with email address and their Full Name.
     *
     * @param bcc recipients list
     * @see #convertRecipients(HashMap) for details
     */
    public void setBcc(HashMap<String,String> bcc) {
        this.bcc = convertRecipients(bcc);
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public void addHeader(String name, String value) {
        if (this.headers == null) {
            setHeaders(new HashMap<>());
        }
        headers.put(name, value);
    }

    public void removeHeader(String name) {
        if (this.headers != null) {
            headers.remove(name);
        }
    }

    public void addAttachment(String path) throws IOException {
        HashMap<String, String> attachment = new HashMap<>();
        attachment.put("Name", new File(path).getName());
        attachment.put("Content", readFileContent(path));
        attachment.put("ContentType", readFileContentType(path));

        addAttachment(attachment);
    }

    public void addAttachment(HashMap<String, String> attachment) {
        attachments.add(attachment);
    }

    public void addAttachments(ArrayList<HashMap<String, String>> attachments) {
        attachments.forEach(this::addAttachment);
    }

    private String readFileContent(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String readFileContentType(String path) {
        File file = new File(path);
        MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
        return MimeUtil.getMimeTypes(file).toString();
    }

    /**
     * This helper method allows setting list of recipients which will contain full name next to email address.
     * By passing something like HashMap of: key -> John Smith, value -> john@example.com
     * you would be able to send email to recipient John Smith ("John Smith" <john@example.com>)
     *
     * @param recipients recipient hashmap, with Full Name, Email address pairs.
     */
    private String convertRecipients(HashMap<String,String> recipients) {

        String recipientsString = "";

        Iterator<HashMap.Entry<String, String>> entries = recipients.entrySet().iterator();
        while (entries.hasNext()) {
            HashMap.Entry<String, String> entry = entries.next();
            recipientsString += "\"" + entry.getKey() + "\"" + "<" + entry.getValue() + ">";
            if (entries.hasNext()) { recipientsString += ","; }
        }

        return recipientsString;
    }

}
