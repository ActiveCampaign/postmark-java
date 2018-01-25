package com.wildbit.java.postmark.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Helper class for creating parameters to pass to API requests. It makes sure proper format of parameters
 * with proper values is used by HTTP clients.
 */
public class Parameters {

    private final HashMap<String,String> parameters;
    public Parameters() {
        parameters = new HashMap<>();
    }

    public static Parameters init() {
        return new Parameters();
    }

    /**
     * Add single parameter to HashMap of stored parameters
     * @param name parameter name
     * @param value parameter value
     * @return object containing currently stored parameters
     */
    public Parameters build(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    /**
     * Add single parameter to HashMap of stored parameters
     * @param name parameter name
     * @param value parameter value
     * @return object containing currently stored parameters
     */
    public Parameters build(String name, Boolean value) {
        parameters.put(name, value.toString());
        return this;
    }

    /**
     *
     * Add single parameter to the HashMap of stored parameters.
     *
     * @param name parameter name
     * @param value parameter value
     *
     * @see #build(String, String)
     * @return this class with additional parameter
     */
    public Parameters build(String name, Integer value) {
        return build(name, value.toString());
    }

    /**
     * Add single parameter to the HashMap of stored parameters.
     *
     * @param name parameter name
     * @param value parameter value
     *
     * @see #build(String, String)
     * @return this class with additional parameter
     */
    public Parameters build(String name, Date value) {
        parameters.put(name, new SimpleDateFormat("yyyy-MM-dd").format(value));
        return this;
    }

    /**
     * It will convert group of parameter to a simple string.
     *
     * @return parameters transformed to proper string format API client accepts
     */
    public String toString() {
        StringBuilder parameterString = new StringBuilder();

        int count = 0;
        for (HashMap.Entry<String, String> entry : parameters.entrySet()) {
            parameterString.append(count==0 ? "?" : "&");
            parameterString.append(entry.getKey());
            parameterString.append("=");
            parameterString.append(entry.getValue());
            count++;
        }

        return parameterString.toString();
    }
}
