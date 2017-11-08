package com.wildbit.java.postmark.client.data;

import com.fasterxml.jackson.databind.*;
import java.io.IOException;

/**
 * This class represents data handler between API client and HTTP client.
 * It makes sure that proper mechanism is used to convert data for HTTP requests and for HTTP responses.
 */
public class DataHandler {

    private final ObjectMapper mapper;

    public DataHandler() {
        this.mapper = new ObjectMapper();
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        setStrictMapper();
    }

    public DataHandler(boolean isStrictMapper) {
        this();

        if (isStrictMapper) {
            setStrictMapper();
        } else {
            setLiberalMapper();
        }
    }

    public String toJson(Object data) throws IOException{
        return this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

    public <T> T fromJson(String response, Class<T> valueType) throws IOException {
        return this.mapper.readValue(response, valueType);
    }

    public String formatErrorMessage(String json_message) throws IOException {
        JsonNode node = fromJson(json_message, JsonNode.class);
        return node.get("Message").textValue();
    }

    /**
     * Sets data mapper to be strict when making conversion of data to POJO objects.
     * If there is a mismatch between POJO object and String in any other case than letter case,
     * exception will be thrown.
     */
    public void setStrictMapper() {
        this.mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }

    /**
     * Sets data mapper to be very liberal when making conversion of data to POJO objects.
     * Most of the time exception will NOT be thrown.
     */
    public void setLiberalMapper() {
        this.mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        this.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
