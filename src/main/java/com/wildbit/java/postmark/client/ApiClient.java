package com.wildbit.java.postmark.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wildbit.java.postmark.client.data.model.bounces.Bounce;
import com.wildbit.java.postmark.client.data.model.bounces.BounceDump;
import com.wildbit.java.postmark.client.data.model.bounces.Bounces;
import com.wildbit.java.postmark.client.data.model.bounces.DeliveryStats;
import com.wildbit.java.postmark.client.data.model.message.Message;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;
import com.wildbit.java.postmark.client.data.model.messages.*;
import com.wildbit.java.postmark.client.data.model.server.Server;
import com.wildbit.java.postmark.client.data.model.stats.*;
import com.wildbit.java.postmark.client.data.model.templates.*;
import com.wildbit.java.postmark.client.data.model.triggers.*;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import javax.ws.rs.core.MultivaluedHashMap;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that handles on very top level all API requests. All Postmark public endpoints which
 * are reachable can be accessible by methods in this class.
 *
 */
public class ApiClient extends BaseApiClient {

    public ApiClient(String baseUrl, MultivaluedHashMap<String, Object> headers) {
        super(baseUrl,headers);
    }

    public ApiClient(String baseUrl, MultivaluedHashMap<String, Object>  headers, boolean secureConnection) {
        super(baseUrl, headers, secureConnection);
    }

    /*

      For details about each endpoint check out Developer Docs:
      https://postmarkapp.com/developer

     */

    /**
     * Email message sending endpoints
     */

    public MessageResponse deliverMessage(Message data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/email"), data);
        return dataHandler.fromJson(response, MessageResponse.class);
    }

    public ArrayList<MessageResponse> deliverMessage(ArrayList<Message> data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/email/batch"), data);
        return  dataHandler.fromJson(response, new TypeReference<ArrayList<MessageResponse>>() {});
    }


    /**
     * Bounced messages endpoints
     */

    public DeliveryStats getDeliveryStats() throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/deliveryStats/"));
        return dataHandler.fromJson(response, DeliveryStats.class);
    }

    public Bounces getBounces(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/bounces" + parameters));
        return dataHandler.fromJson(response, Bounces.class);
    }

    public Bounce getBounce(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/bounces/" + id));
        return dataHandler.fromJson(response, Bounce.class);
    }

    public BounceDump getBounceDump(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/bounces/" + id + "/dump"));
        return dataHandler.fromJson(response, BounceDump.class);
    }

    public String activateBounce(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/bounces/" + id + "/activate"));
    }

    public ArrayList getBounceTags() throws PostmarkException, IOException {
        return dataHandler.fromJson(execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/bounces/tags")), ArrayList.class);
    }


    /**
     * Template handling endpoints
     */

    public Template getTemplate(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/templates/" + id));
        return dataHandler.fromJson(response, Template.class);
    }

    public BaseTemplate createTemplate(TemplateContent data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/templates/"), data);
        return dataHandler.fromJson(response, BaseTemplate.class);
    }

    public BaseTemplate setTemplate(Integer id, TemplateContent data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/templates/" + id), data);
        return dataHandler.fromJson(response, BaseTemplate.class);
    }

    public Templates getTemplates(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/templates/" + parameters));
        return dataHandler.fromJson(response, Templates.class);
    }

    public String deleteTemplate(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl("/templates/" + id));
    }

    public TemplateValidation validateTemplate(TemplateToValidate data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/templates/validate"), data);
        return dataHandler.fromJson(response, TemplateValidation.class);
    }

    public MessageResponse deliverMessage(TemplatedMessage data) throws PostmarkException, IOException {

        /*

          Since template models can be complex, it is allowed that template model is a String or Object.
          If it's a String, we will auto convert it to Object.

         */
        if (data.getTemplateModel().getClass() == String.class) {
            data.setTemplateModel(dataHandler.fromJson(data.getTemplateModel().toString(),Object.class));
        }
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/email/withTemplate"), data);
        System.out.println(response);
        return dataHandler.fromJson(response, MessageResponse.class);
    }


    /**
     * Server endpoints for managing Servers in account.
     */

    public Server getServer() throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/server"));
        return dataHandler.fromJson(response, Server.class);
    }

    public Server setServer(Server data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/server"), data);
        return dataHandler.fromJson(response, Server.class);
    }

    /*
      Messages endpoints
     */

    /**
     * Outbound Messages
     */

    public OutboundMessages getMessages(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/outbound" + parameters));
        return dataHandler.fromJson(response, OutboundMessages.class);
    }

    public OutboundMessageDetails getMessageDetails(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/outbound/" + id + "/details"));
        return dataHandler.fromJson(response, OutboundMessageDetails.class);
    }

    public OutboundMessageDump getMessageDump(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/outbound/" + id + "/dump"));
        return dataHandler.fromJson(response, OutboundMessageDump.class);
    }

    public OutboundMessageOpens getMessageOpens(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/outbound/opens" + parameters));
        return dataHandler.fromJson(response, OutboundMessageOpens.class);
    }

    public OutboundMessageOpens getMessageOpens(String id, Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/outbound/opens/" + id + parameters));
        return dataHandler.fromJson(response, OutboundMessageOpens.class);
    }

    public OutboundMessageClicks getMessageClicks(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/outbound/clicks" + parameters));
        return dataHandler.fromJson(response, OutboundMessageClicks.class);
    }

    public OutboundMessageClicks getMessageClicks(String id, Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/outbound/clicks/" + id + parameters));
        return dataHandler.fromJson(response, OutboundMessageClicks.class);
    }

    /**
     * Inbound Messsages
     */

    public InboundMessages getInboundMessages(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/inbound" + parameters));
        return dataHandler.fromJson(response, InboundMessages.class);
    }

    public InboundMessageDetails getInboundMessageDetails(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/messages/inbound/" + id + "/details"));
        return dataHandler.fromJson(response, InboundMessageDetails.class);
    }

    public String bypassInboundMessage(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/messages/inbound/" + id + "/bypass"));
        return dataHandler.fromJson(response, String.class);
    }

    public String retryFailedInboundMessage(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/messages/inbound/" + id + "/retry"));
        return dataHandler.fromJson(response, String.class);
    }

    /**
     * Stats Endpoints
     */

    public OutboundStats getOutboundStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound" + parameters));
        return dataHandler.fromJson(response, OutboundStats.class);
    }

    public OutboundSendStats getOutboundSendStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/sends" + parameters));
        return dataHandler.fromJson(response, OutboundSendStats.class);
    }

    public OutboundBounceStats getOutboundBounceStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/bounces" + parameters));
        return dataHandler.fromJson(response, OutboundBounceStats.class);
    }

    public OutboundSpamStats getOutboundSpamStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/spam" + parameters));
        return dataHandler.fromJson(response, OutboundSpamStats.class);
    }

    public OutboundTrackedStats getOutboundTrackedStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/tracked" + parameters));
        return dataHandler.fromJson(response, OutboundTrackedStats.class);
    }

    public OutboundOpenStats getOutboundOpenStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/opens" + parameters));
        return dataHandler.fromJson(response, OutboundOpenStats.class);
    }

    public OutboundOpenPlatformStats getOutboundOpenPlatformStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/opens/platforms" + parameters));
        return dataHandler.fromJson(response, OutboundOpenPlatformStats.class);
    }

    public String getOutboundOpenClientStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/opens/platforms" + parameters));
        return dataHandler.fromJson(response, String.class);
    }

    public String getOutboundOpenReadTimes(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/opens/readTimes" + parameters));
        return dataHandler.fromJson(response, String.class);
    }

    public OutboundClickStats getOutboundClickStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/clicks" + parameters));
        return dataHandler.fromJson(response, OutboundClickStats.class);
    }

    public OutboundClickPlatformStats getOutboundClickPlatformStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/clicks/platforms" + parameters));
        return dataHandler.fromJson(response, OutboundClickPlatformStats.class);
    }

    public OutboundClickLocationStats getOutboundClickLocationStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/stats/outbound/clicks/location" + parameters));
        return dataHandler.fromJson(response, OutboundClickLocationStats.class);
    }


    /**
     * Trigger Tags endpoints
     */

    public TagMatcher createTriggerTag(TagMatcher data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/triggers/tags"), data);
        return dataHandler.fromJson(response, TagMatcher.class);
    }

    public TagMatcher getTriggerTag(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/triggers/tags/" + id));
        return dataHandler.fromJson(response, TagMatcher.class);
    }

    public TagMatcher setTriggerTag(Integer id, TagMatcher data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl("/triggers/tags/" + id), data);
        return dataHandler.fromJson(response, TagMatcher.class);
    }

    public String deleteTriggerTag(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl("/triggers/tags/" + id));
    }

    public TagMatchers getTriggerTags(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/triggers/tags" + parameters));
        return dataHandler.fromJson(response, TagMatchers.class);
    }


    /**
     * Trigger Inbound Rules endpoints
     */

    public InboundRuleResponse createInboundRule(String rule) throws PostmarkException, IOException {
        InboundRule data = new InboundRule();
        data.setRule(rule);
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl("/triggers/inboundRules"), data);
        return dataHandler.fromJson(response, InboundRuleResponse.class);
    }

    public String deleteInboundRule(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl("/triggers/inboundRules/" + id));
    }

    public InboundRules getInboundRules(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/triggers/inboundRules" + parameters));
        return dataHandler.fromJson(response, InboundRules.class);
    }

}
