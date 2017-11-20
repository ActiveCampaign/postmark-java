package com.wildbit.java.postmark.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
        String parameterString = "";

        for (HashMap.Entry<String, String> entry : parameters.entrySet()) {
            parameterString += addParameters(parameterString, entry.getKey() + "=" + entry.getValue());
        }

        return parameterString;
    }

    /**
     * Convert parameter to a String to attach to parameter list string.
     *
     * @param parameter single HTTP request parameter name
     * @param value single HTTP request parameter value
     * @return parameter as String
     */
    private String addParameters(String parameter, String value) {
        if (parameter.isEmpty()) {
            return  "?" + value;
        }
        else{
            return  "&" + value;
        }
    }
}
