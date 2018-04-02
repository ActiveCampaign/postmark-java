package unit.client;

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
        assertEquals("?fromAddress=igor@example.com",parameters.toString());
    }

    @Test
    void integerParameter() {
        Parameters parameters = Parameters.init().build("count",1);
        assertEquals("?count=1",parameters.toString());
    }

    @Test
    void dateFromParameter() throws ParseException {
        String parameters = Parameters.init().build("fromDate", sampleDate(dateString)).toString();
        assertEquals("?fromDate=" + dateString, parameters.toString());
    }

    @Test
    void dateToParameter() throws ParseException {
        String parameters = Parameters.init().build("toDate", sampleDate(dateString)).toString();
        assertEquals("?toDate=" + dateString, parameters.toString());
    }

    @Test
    void multipleParameters() throws ParseException {
        Parameters parameters = Parameters.init().build("fromDate",sampleDate(dateString)).build("count",1).build("offset",0);
        assertEquals("?fromDate=" + dateString + "&offset=0&count=1",parameters.toString());
    }
}
