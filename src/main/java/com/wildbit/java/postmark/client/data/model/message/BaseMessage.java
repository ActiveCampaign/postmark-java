package com.wildbit.java.postmark.client.data.model.message;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import eu.medsea.mimeutil.MimeUtil;

/**
 * Base email message object
 */
public class BaseMessage {
    private String messageStream;
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String replyTo;
    private String subject;
    private String htmlBody;
    private String textBody;
    private String tag;
    private List<Header> headers;
    private List<Map<String, String>> attachments;

    public BaseMessage() {
        this.attachments = new ArrayList<>();
    }

    public BaseMessage(String from, String to, String subject, String htmlBody) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.htmlBody = htmlBody;
        this.attachments = new ArrayList<>();
    }

    public BaseMessage(String from, String to, String subject, String htmlBody, String textBody) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.htmlBody = htmlBody;
        this.textBody = textBody;
        this.attachments = new ArrayList<>();
    }

    public BaseMessage(String from, String to, String subject, String htmlBody, String textBody, String messageStream) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.htmlBody = htmlBody;
        this.textBody = textBody;
        this.messageStream = messageStream;
        this.attachments = new ArrayList<>();
    }

    // SETTERS AND GETTERS

    public String getMessageStream() {
        return messageStream;
    }

    public void setMessageStream(String messageStream) {
        this.messageStream = messageStream;
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

    /**
     * Helper method for setting Array of recipient email addresses.
     *
     * @param to recipients list
     * @see #convertRecipients(Map) for details
     */
    public void setTo(List<String > to) {
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

    /**
     * Helper method for setting Array of recipient email addresses.
     *
     * @param cc recipients list
     * @see #convertRecipients(Map) for details
     */
    public void setCc(List<String > cc) {
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

    /**
     * Helper method for setting Array of recipient email addresses.
     *
     * @param bcc recipients list
     * @see #convertRecipients(Map) for details
     */
    public void setBcc(List<String > bcc) {
        this.bcc = convertRecipients(bcc);
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
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
     * @throws IOException
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
     * @param recipients recipient Map, with Full Name, Email address pairs.
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

    private String convertRecipients(List<String> recipients) {

        StringBuilder recipientsString = new StringBuilder();

        Iterator<String> entries = recipients.iterator();
        while (entries.hasNext()) {
            String entry = entries.next();
            recipientsString.append("\"").append(entry).append("\"");
            if (entries.hasNext()) { recipientsString.append(","); }
        }

        return recipientsString.toString();
    }

}
