package com.postmarkapp.postmark.client;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Base HTTP client class solely responsible for making
 * client requests and returning simple HTTP response.
 */
public class HttpClient {

    // HTTP request connection timeouts
    public enum DEFAULTS {
        CONNECT_TIMEOUT_SECONDS(60),
        READ_TIMEOUT_SECONDS(60);

        public final int value;

        DEFAULTS(int value) {
            this.value = value;
        }
    }

    private final Map<String,Object> headers;
    private CloseableHttpClient client;
    // client configuration options like timeouts, forwarding ..
    private RequestConfig.Builder clientConfigBuilder;

    private boolean secureConnection = true;

    public HttpClient(Map<String,Object> headers, int connectTimeoutSeconds, int readTimeoutSeconds) {
        this.headers = headers;
        this.clientConfigBuilder = RequestConfig
                .custom()
                .setConnectTimeout(Timeout.ofSeconds(connectTimeoutSeconds))
                .setResponseTimeout(Timeout.ofSeconds(readTimeoutSeconds));

        this.client = buildClient();
    }

    public HttpClient(Map<String,Object> headers) {
        this(headers, DEFAULTS.CONNECT_TIMEOUT_SECONDS.value, DEFAULTS.READ_TIMEOUT_SECONDS.value);
    }

    /**
     * Overload method for executing requests, which doesn't contain data
     *
     * @param request_type type of HTTP request
     * @param url request URL
     * @return simplified HTTP request response (status and response text)
     *
     * @see #execute(REQUEST_TYPES, String, String) for details
     */
    public ClientResponse execute(REQUEST_TYPES request_type, String url) throws IOException {
        return execute(request_type, url, null);
    }

    /**
     *
     * Execute HTTP request.
     *
     * @param requestType type of HTTP request to initiate
     * @param url request url
     * @param data data sent for POST/PUT requests
     * @return response from HTTP request
     */
    public ClientResponse execute(REQUEST_TYPES requestType, String url, String data) throws IOException {
        ClassicHttpRequest request;

        switch (requestType) {
            case POST:
                request = ClassicRequestBuilder.post(getHttpUrl(url)).setEntity(data, ContentType.APPLICATION_JSON).build();
                break;

            case PUT:
                request = ClassicRequestBuilder.put(getHttpUrl(url)).setEntity(data, ContentType.APPLICATION_JSON).build();
                break;

            case PATCH:
                request = ClassicRequestBuilder.patch(getHttpUrl(url)).setEntity(data, ContentType.APPLICATION_JSON).build();
                break;

            case DELETE:
                request = ClassicRequestBuilder.delete(getHttpUrl(url)).build();
                break;

            default:
                request = ClassicRequestBuilder.get(getHttpUrl(url)).build();
                break;
        }

        for (Map.Entry<String, Object> header : headers.entrySet()) {
            request.setHeader(header.getKey(), header.getValue().toString());
        }

        return client.execute(
                request,
                response -> new ClientResponse(response.getCode(), EntityUtils.toString(response.getEntity())));
    }

    // Setters and Getters

    public void setConnectTimeoutSeconds(int connectTimeoutSeconds) {
        clientConfigBuilder.setConnectTimeout(Timeout.ofSeconds(connectTimeoutSeconds));
        this.client = buildClient();
    }

    public void setReadTimeoutSeconds(int readTimeoutSeconds) {
        clientConfigBuilder.setResponseTimeout(Timeout.ofSeconds(readTimeoutSeconds));
        this.client = buildClient();
    }

    public void setSecureConnection(boolean secureConnection) {
        this.secureConnection = secureConnection;
    }

    private String getHttpUrl(String url) {
        String urlPrefix = this.secureConnection ? "https://" : "http://";
        return urlPrefix + url;
    }

    /**
     * Access to original HTTP client used for requests
     *
     * @return original HTTP client
     */
    public CloseableHttpClient getClient() {
        return client;
    }

    /**
     * Build default HTTP client used for requests
     *
     * @return initialized HTTP client
     */
    private CloseableHttpClient buildClient() {
        return HttpClientBuilder.create().setDefaultRequestConfig(clientConfigBuilder.build()).build();
    }

    /**
     * Class that represents simplified HTTP request response.
     */
    public class ClientResponse {

        private final int code;
        private final String message;

        public ClientResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }
        public String getMessage() {
            return message;
        }
    }

    /**
     * Allowed HTTP request types.
     */
    public enum REQUEST_TYPES {
        POST,
        GET,
        PUT,
        PATCH,
        DELETE
    }
}
