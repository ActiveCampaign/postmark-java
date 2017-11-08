package com.wildbit.java.postmark.client;

import com.wildbit.java.postmark.client.data.model.domains.*;
import com.wildbit.java.postmark.client.data.model.senders.*;
import com.wildbit.java.postmark.client.data.model.server.Server;
import com.wildbit.java.postmark.client.data.model.servers.Servers;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import javax.ws.rs.core.MultivaluedHashMap;
import java.io.IOException;

/**
 * Class that handles on very top level all API requests. All Postmark public endpoints which
 * are reachable can be accessible by methods in this class.
 *
 */
public class AccountApiClient extends BaseApiClient {

    public AccountApiClient(String baseUrl, MultivaluedHashMap<String,Object> headers) {
        super(baseUrl,headers);
    }

    public AccountApiClient(String baseUrl, MultivaluedHashMap<String,Object> headers, boolean secureConnection) {
        super(baseUrl, headers, secureConnection);
    }

    /*
      For details about each endpoint check out Developer Docs:
      https://postmarkapp.com/developer
     */

    /**
     * Servers endpoints for managing Servers in account.
     */

    public Server getServers(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/servers/" + id));
        return dataHandler.fromJson(response, Server.class);
    }

    public Server createServer(Server data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/servers"), data);
        return dataHandler.fromJson(response, Server.class);
    }

    public Server setServer(Integer id, Server data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/servers/" + id), data);
        return dataHandler.fromJson(response, Server.class);
    }

    public Servers getServers(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/servers" + parameters));
        return dataHandler.fromJson(response, Servers.class);
    }

    public String deleteServer(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl("/servers/" + id));
    }


    /**
     * Domain endpoints
     */

    public Domains getDomains(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/domains" + parameters));
        return dataHandler.fromJson(response, Domains.class);
    }

    public DomainDetails getDomainDetails(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/domains/" + id));
        return dataHandler.fromJson(response, DomainDetails.class);
    }

    public DomainDetails createDomain(Domain domain) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/domains"), domain);
        return dataHandler.fromJson(response, DomainDetails.class);
    }

    public DomainDetails setDomain(Integer id, DomainDetails domain) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/domains/" + id), domain);
        return dataHandler.fromJson(response, DomainDetails.class);
    }

    public String deleteDomain(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl("/domains/" + id));
    }

    public String verifyDomainSPF(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/domains/" + id + "/verifySPF"));
    }

    public String rotateDomainDKIM(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/domains/" + id + "/rotateDKIM"));
    }


    /**
     * Sender Signature endpoints
     */

    public Signatures getSenderSignatures(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/senders" + parameters));
        return dataHandler.fromJson(response, Signatures.class);
    }

    public SignatureDetails getSenderSignatureDetails(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/senders/" + id));
        return dataHandler.fromJson(response, SignatureDetails.class);
    }

    public SignatureDetails createSenderSignature(SignatureToCreate signature) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/senders"), signature);
        return dataHandler.fromJson(response, SignatureDetails.class);
    }

    public SignatureDetails setSenderSignature(Integer id, SignatureToCreate signature) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/senders/" + id), signature);
        return dataHandler.fromJson(response, SignatureDetails.class);
    }

    public String deleteSenderSignature(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl("/senders/" + id));
    }

    public String resendSenderSignatureConfirmation(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/senders/" + id + "/resend"));
    }

    public SignatureDetails verifySenderSignatureSPF(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/senders/" + id + "/verifySPF"));
        return dataHandler.fromJson(response, SignatureDetails.class);
    }

    public String requestSenderSignatureDKIM(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/senders/" + id + "/requestNewDKIM"));
    }

}
