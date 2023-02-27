package com.postmarkapp.postmark.client;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;
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
    private final Client client;

    private boolean secureConnection = true;

    public HttpClient(Map<String,Object> headers, int connectTimeoutSeconds, int readTimeoutSeconds) {
        this(headers);
        setConnectTimeoutSeconds(connectTimeoutSeconds);
        setReadTimeoutSeconds(readTimeoutSeconds);
    }

    public HttpClient(Map<String,Object> headers) {
        this.headers = headers;
        this.client = buildClient();
        setReadTimeoutSeconds(DEFAULTS.READ_TIMEOUT_SECONDS.value);
        setConnectTimeoutSeconds(DEFAULTS.CONNECT_TIMEOUT_SECONDS.value);
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
    public ClientResponse execute(REQUEST_TYPES requestType, String url, String data) {
        Response response;
        final Builder requestBuilder = clientRequestBuilder((url));

        switch (requestType) {
            case POST:
                response = requestBuilder.post(Entity.json(data), Response.class);
                break;

            case PUT:
                response = requestBuilder.put(Entity.json(data), Response.class);
                break;

            case PATCH:
                response = requestBuilder.method("PATCH", Entity.json(data), Response.class);
                break;

            case DELETE:
                response = requestBuilder.delete(Response.class);
                break;

            default:
                response = requestBuilder.get(Response.class);
                break;

        }

        return transformResponse(response);
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
    public ClientResponse execute(REQUEST_TYPES request_type, String url) {
        return execute(request_type, url, null);
    }

    // Setters and Getters

    public void setConnectTimeoutSeconds(int connectTimeoutSeconds) {
        client.property(ClientProperties.CONNECT_TIMEOUT, connectTimeoutSeconds * 1000);
    }

    public void setReadTimeoutSeconds(int readTimeoutSeconds) {
        client.property(ClientProperties.READ_TIMEOUT, readTimeoutSeconds * 1000);
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
    public Client getClient() {
        return client;
    }

    /**
     * Build default HTTP client used for requests
     *
     * Jersey client uses HttpUrlConnection by default which doesn't have PATCH method:
     * https://docs.oracle.com/javase/8/docs/api/java/net/HttpURLConnection.html#setRequestMethod-java.lang.String-
     * https://github.com/eclipse-ee4j/jersey/issues/4825
     *
     * Workaround for being able to do PATCH requests is by using reflection, which would work up to Java 16.
     * https://stackoverflow.com/questions/55778145/how-to-use-patch-method-with-jersey-invocation-builder
     *
     * @return initialized HTTP client
     */
    private Client buildClient() {
        Client client = ClientBuilder.newClient();
        // this allows calls to PATCH by using reflection
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        return client;
    }

    private Builder clientRequestBuilder(String url) {
        Builder requestBuilder = client.target(getHttpUrl(url)).request();

        for (Map.Entry<String, Object> header : headers.entrySet()) {
            requestBuilder.header(header.getKey(), header.getValue());
        }

        return requestBuilder;
    }

    /**
     * Build HTTP client with custom config used for requests
     * like:
     *
     * ClientConfig clientConfig = new ClientConfig();
     * clientConfig.connectorProvider(new GrizzlyConnectorProvider());
     * clientConfig.connectorProvider(new HttpUrlConnectorProvider().useSetMethodWorkaround());
     */
    private Client buildClient(ClientConfig config) {
        return ClientBuilder.newClient(config);
    }

    /**
     *  Gets simplified HTTP request response that will contain only response and status.
     *
     * @param response HTTP request response result
     * @return simplified HTTP request response
     */
    private ClientResponse transformResponse(Response response) {
        return new ClientResponse(response.getStatus(), response.readEntity(String.class));
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
