package client;

import com.wildbit.java.postmark.client.Parameters;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Parameters class tests.
 */
public class ParametersTest {

    private String dateString = "2017-01-01";

    private Date sampleDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dateString);
    }

    @Test
    void init() {
        assertSame(Parameters.init().getClass(),Parameters.class);
    }

    @Test
    void initString() {
        assertEquals(Parameters.init().toString(), "");
    }

    @Test
    void build() {
        assertEquals(Parameters.init().build("fromAddress","igor@example.com").getClass(), Parameters.class);
    }

    @Test
    void stringParameter() {
        Parameters parameters = Parameters.init().build("fromAddress","igor@example.com");
        assertEquals(parameters.toString(),"?fromAddress=igor@example.com");
    }

    @Test
    void integerParameter() {
        Parameters parameters = Parameters.init().build("count",1);
        assertEquals(parameters.toString(),"?count=1");
    }

    @Test
    void dateParameter() throws ParseException {
        String parameters = Parameters.init().build("fromDate", sampleDate(dateString)).toString();
        assertEquals(parameters,"?fromDate=" + dateString);
    }

    @Test
    void multipleParameters() throws ParseException {
        Parameters parameters = Parameters.init().build("fromDate",sampleDate(dateString)).build("count",1).build("offset",0);
        assertEquals(parameters.toString(),"?fromDate=" + dateString + "&offset=0&count=1");
    }
}
