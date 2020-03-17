package com.wildbit.java.postmark.client.data.model.templates;

import com.wildbit.java.postmark.client.data.model.message.Header;
import eu.medsea.mimeutil.MimeUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Base Template object.
 */
public class BaseTemplatedMessage {

    private Integer templateId;
    private String templateAlias;
    private Object templateModel;
    private String messageStream;
    private Boolean inlineCss;
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String replyTo;
    private String tag;
    private List<Header> headers;
    private List<Map<String, String>> attachments;

    public BaseTemplatedMessage() {
        this.setAttachments(new ArrayList<>());
        this.setInlineCss(false);
        this.setTemplateModel(new HashMap<>());
    }

    public BaseTemplatedMessage(String from, String to) {
        this();
        this.from = from;
        this.to = to;
    }

    public BaseTemplatedMessage(String from, String to, String templateAlias) {
        this();
        this.from = from;
        this.to = to;
        this.templateAlias = templateAlias;
    }

    public BaseTemplatedMessage(String from, String to, String templateAlias, String messageStream) {
        this();
        this.from = from;
        this.to = to;
        this.templateAlias = templateAlias;
        this.messageStream = messageStream;
    }

    public BaseTemplatedMessage(String from, String to, Integer templateId) {
        this();
        this.from = from;
        this.to = to;
        this.templateId = templateId;
    }

    public BaseTemplatedMessage(String from, String to, Integer templateId, String messageStream) {
        this();
        this.from = from;
        this.to = to;
        this.templateId = templateId;
        this.messageStream = messageStream;
    }


    // SETTERS AND GETTERS

    public String getMessageStream() {
        return messageStream;
    }

    public void setMessageStream(String messageStream) {
        this.messageStream = messageStream;
    }

    public String getTemplateAlias() { return templateAlias; }

    public void setTemplateAlias(String templateAlias) { this.templateAlias = templateAlias; }

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
     * @see #convertRecipients(Map) for details
     */
    public void setTo(Map<String,String> to) {
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
     * @see #convertRecipients(Map) for details
     */
    public void setCc(Map<String,String> cc) {
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
     * @see #convertRecipients(Map) for details
     */
    public void setBcc(Map<String,String> bcc) {
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

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public void addHeader(String name, String value) {
        if (this.headers == null) {
            setHeaders(new ArrayList<>());
        }
        this.headers.add(new Header(name,value));
    }

    public void clearHeaders() {
        if (this.headers != null) {
            this.headers.clear();
        }
    }

    public List<Map<String, String>> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Map<String, String>> attachments) {
        this.attachments = attachments;
    }

    /**
     * Add attachments from file path
     *
     * @param path file path
     */
    public void addAttachment(String path) throws IOException {
        addAttachment(new File(path).getName(), readFileContent(path), readFileContentType(path));
    }

    /**
     * Add attachments from file path with content id. Easiest way to add inline image attachments.
     *
     * @param path file path
     * @param contentId file content id, like "cid:image.jpg", very usefull for inline images
     */
    public void addAttachment(String path, String contentId) throws IOException {
        addAttachment(new File(path).getName(), readFileContent(path), readFileContentType(path), contentId);
    }

    /**
     * Add attachments by file details
     *
     * @param filename filename to show up in email
     * @param content file content
     * @param contentType file content type
     * @param contentId file content id
     */
    public void addAttachment(String filename, String content, String contentType, String contentId) {
        addAttachment(filename, content.getBytes(),contentType, contentId);
    }

    /**
     * Add attachments by file details
     *
     * @param filename filename to show up in email
     * @param content file content
     * @param contentType file content type
     */
    public void addAttachment(String filename, String content, String contentType) {
        addAttachment(filename, content.getBytes(),contentType);
    }

    /**
     * Add attachments by file details
     *
     * @param name filename to show up in email
     * @param content file content
     * @param contentType file content type
     */
    public void addAttachment(String name, byte[] content, String contentType) {
        Map<String, String> attachment = new HashMap<>();
        attachment.put("Name", name);
        attachment.put("Content", Base64.getEncoder().encodeToString(content));
        attachment.put("ContentType", contentType);

        addAttachment(attachment);
    }

    /**
     * Add attachments by file details
     *
     * @param name filename to show up in email
     * @param content file content
     * @param contentType file content type
     * @param contentId file content id, like "cid:image.jpg", very usefull for inline images
     */
    public void addAttachment(String name, byte[] content, String contentType, String contentId) {
        Map<String, String> attachment = new HashMap<>();
        attachment.put("Name", name);
        attachment.put("Content", Base64.getEncoder().encodeToString(content));
        attachment.put("ContentType", contentType);
        attachment.put("ContentId", contentId);

        addAttachment(attachment);
    }

    /**
     * Add attachments as hash. To add it, attachment needs to look like this:
     *
     * attachment.put("Name", "filename.txt");
     * attachment.put("Content", Base64.getEncoder().encodeToString("test content".getBytes()));
     * attachment.put("ContentType", "application/text");
     *
     * @param attachment hash map of attachment.
     */
    public void addAttachment(Map<String, String> attachment) {
        if (this.attachments == null) {
            this.attachments = new ArrayList<>();
        }
        attachments.add(attachment);
    }

    public void addAttachments(List<Map<String, String>> attachments) {
        attachments.forEach(this::addAttachment);
    }

    private byte[] readFileContent(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    private String readFileContentType(String path) {
        File file = new File(path);
        MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
        return MimeUtil.getMimeTypes(file).toString();
    }

    /**
     * This helper method allows setting list of recipients which will contain full name next to email address.
     * By passing something like Map of: key -> John Smith, value -> john@example.com
     * you would be able to send email to recipient John Smith ("John Smith" <john@example.com>)
     *
     * @param recipients recipient map, with Full Name, Email address pairs.
     */
    private String convertRecipients(Map<String,String> recipients) {

        StringBuilder recipientsString = new StringBuilder();

        Iterator<Map.Entry<String, String>> entries = recipients.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            recipientsString.append("\"").append(entry.getKey()).append("\"").append("<").append(entry.getValue()).append(">");
            if (entries.hasNext()) { recipientsString.append(","); }
        }

        return recipientsString.toString();
    }

}
