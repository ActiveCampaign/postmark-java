package com.wildbit.java.postmark.client.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * In some of the responses from Postmark API, date format is not detected correctly by Jackson.
 * This class handles additional custom date formats when deserializing data.
 */
public class CustomDateDeserializer extends StdDeserializer<Date> {
    private static final long serialVersionUID = 1L;

    private static final String[] DATE_FORMATS = new String[] {
            "EEE, dd MMM yyyy HH:mm:ss zzz",
            "dd MMM yyyy HH:mm:ss zzz",
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
            "yyyy-MM-dd'T'HH:mm:ss.SSS",
            "yyyy-MM-dd"
    };


    public CustomDateDeserializer() {
        this(null);
    }

    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final String date = node.textValue();

        for (String DATE_FORMAT : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(DATE_FORMAT).parse(date);
            } catch (ParseException e) { }
        }

        throw new JsonParseException(jsonParser, getParsingErrorMessage(date));
    }

    private String getParsingErrorMessage(String date) {
        return "Not parsable date: \"" + date + "\". Supported formats: " + Arrays.toString(DATE_FORMATS);
    }

}