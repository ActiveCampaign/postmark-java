package com.wildbit.java.postmark.client.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.wildbit.java.postmark.client.data.model.PostmarkError;

import java.io.IOException;

/**
 * This class represents data handler between API client and HTTP client.
 * It makes sure that proper mechanism is used to convert data for HTTP requests and for HTTP responses.
 */
public class DataHandler {

    private final ObjectMapper mapper;

    public DataHandler() {
        this.mapper = new ObjectMapper();
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        setLiberalMapper();
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

    /**
     *
     * @param response JSON object in String format
     * @param valueType accepts types like ArrayList
     * @param <T> Class type to return
     * @return requested object type
     * @throws IOException in case converting String to Object fails
     */
    public <T> T fromJson(String response, Class<T> valueType) throws IOException {
        return this.mapper.readValue(response, valueType);
    }

    /**
     *
     * @param response JSON object in String format
     * @param valueType accepts parametrized types
     * @param <T> Class type to return
     * @return String object converted to requested object
     * @throws IOException in case converting String to Object fails
     */
    public <T> T fromJson(String response, TypeReference<T> valueType) throws IOException {
        return this.mapper.readValue(response, valueType);
    }

    /**
     * Sets data mapper to be strict when making conversion of data to objects.
     * If there is a mismatch between object and String in any other case than letter case,
     * exception will be thrown.
     */
    public void setStrictMapper() {
        this.mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }

    /**
     * Sets data mapper to be very liberal when making conversion of data to objects.
     * Most of the time exception will NOT be thrown.
     */
    public void setLiberalMapper() {
        this.mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        this.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
