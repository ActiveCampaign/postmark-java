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

    public Parameters build(String type, String value) {
        parameters.put(type, value);
        return this;
    }

    public Parameters build(String type, Integer value) {
        return build(type, value.toString());
    }

    public Parameters build(String type, Date value) {
        parameters.put(type, new SimpleDateFormat("yyyy-MM-dd").format(value));
        return this;
    }

    public String toString() {
        String parameterString = "";

        for (HashMap.Entry<String, String> entry : parameters.entrySet()) {
            parameterString += addParameters(parameterString, entry.getKey() + "=" + entry.getValue());
        };

        return parameterString;
    }

    private String addParameters(String parameter, String value) {
        if (parameter.isEmpty()) {
            return  "?" + value;
        }
        else{
            return  "&" + value;
        }
    }
}
