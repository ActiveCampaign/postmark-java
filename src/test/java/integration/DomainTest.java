package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.domains.DomainDetails;
import com.wildbit.java.postmark.client.data.model.domains.Domains;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by bash on 11/14/17.
 */
public class DomainTest extends BaseTest {

    AccountApiClient client = getDefaultAccountApiClient();

    @Test
    void list() throws PostmarkException, IOException {
        Domains domains = client.getDomains(Parameters.init().build("count",6).build("offset",0));
        assertTrue(domains.getDomains().size() > 0);
    }

    @Test
    void listById() throws PostmarkException, IOException {
        Domains domains = client.getDomains(Parameters.init().build("count",6).build("offset",0));
        Integer domainId = domains.getDomains().get(0).getId();
        DomainDetails domainDetails = client.getDomainDetails(domainId);
        assertNotNull(domainDetails.getDkimTextValue());
    }

    @Test
    void verifySPF() throws PostmarkException, IOException {
        Domains domains = client.getDomains(Parameters.init().build("count",6).build("offset",0));
        Integer domainId = domains.getDomains().get(0).getId();
        String response = client.verifyDomainSPF(domainId);
        assertNotNull(response);
    }

    @Test
    void verifyDKIM() throws PostmarkException, IOException {
        Domains domains = client.getDomains(Parameters.init().build("count",6).build("offset",0));
        Integer domainId = domains.getDomains().get(0).getId();
        DomainDetails domainDetails = client.verifyDomainDKIM(domainId);
        assertNotNull(domainDetails.getDkimTextValue());
    }

    @Test
    void verifyReturnPath() throws PostmarkException, IOException {
        Domains domains = client.getDomains(Parameters.init().build("count",6).build("offset",0));
        Integer domainId = domains.getDomains().get(0).getId();
        DomainDetails domainDetails = client.verifyDomainReturnPath(domainId);
        assertNotNull(domainDetails.getDkimTextValue());
    }

}
