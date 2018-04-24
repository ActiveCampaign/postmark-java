package com.wildbit.java.postmark;

import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.ApiClient;

import javax.ws.rs.core.MultivaluedHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Top level class allowing simple access to API clients for doing Postmark API calls.
 */
public class Postmark {

    /**
     * Base Postmark APP Constants
     */
    public enum DEFAULTS {
        API_URL("api.postmarkapp.com"),
        SERVER_AUTH_HEADER("X-Postmark-Server-Token"),
        ACOUNT_AUTH_HEADER("X-Postmark-Account-Token");

        public final String value;

        DEFAULTS(String value) {
            this.value = value;
        }
    }

    /**
     *  Default headers sent always with API requests.
     */
    public static class DefaultHeaders {

        public static MultivaluedHashMap<String, String> headers() {
            MultivaluedHashMap<String, String> headerValues = new MultivaluedHashMap<>();
            headerValues.add("User-Agent", "Postmark Java Library: " + libraryVersion());
            headerValues.add("Accept", "application/json");
            headerValues.add("Content-Type", "application/json");
            return headerValues;
        }

    }

    public static String libraryVersion()  {
        Properties prop = new Properties();
        InputStream in =  Postmark.class.getClassLoader().getResourceAsStream(".properties");

        try { prop.load(in); } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty("Version");
    }

    // public class methods for accessing API clients

    public static ApiClient getApiClient(String apiToken) {
        return new ApiClient(DEFAULTS.API_URL.value, getHeadersWithAuth(DEFAULTS.SERVER_AUTH_HEADER, apiToken));
    }

    public static ApiClient getApiClient(String apiToken, Boolean secureConnection) {
        return new ApiClient(DEFAULTS.API_URL.value, getHeadersWithAuth(DEFAULTS.SERVER_AUTH_HEADER, apiToken), secureConnection);
    }

    public static AccountApiClient getAccountApiClient(String apiToken) {
        return new AccountApiClient(DEFAULTS.API_URL.value, getHeadersWithAuth(DEFAULTS.ACOUNT_AUTH_HEADER, apiToken));
    }

    public static AccountApiClient getAccountApiClient(String apiToken, Boolean secureConnection) {
        return new AccountApiClient(DEFAULTS.API_URL.value, getHeadersWithAuth(DEFAULTS.ACOUNT_AUTH_HEADER, apiToken), secureConnection);
    }

    // private methods

    private Postmark() {}

    private static MultivaluedHashMap getHeadersWithAuth(DEFAULTS authType, String apiToken) {
        MultivaluedHashMap headers = DefaultHeaders.headers();
        headers.add(authType.value, apiToken);
        return headers;
    }
}
