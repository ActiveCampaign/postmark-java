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

import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that handles on very top level all API requests. All Postmark public endpoints which
 * are reachable can be accessible by methods in this class.
 *
 * For details about each endpoint check out Developer Docs:
 * https://postmarkapp.com/developer
 *
 */
public class ApiClient extends BaseApiClient {

    private final String bouncesEndpoint        = "/bounces/";
    private final String templatesEndpoint      = "/templates/";
    private final String serverEndpoint         = "/server/";
    private final String outboundMessagesEndpoint       = "/messages/outbound/";
    private final String inboundMessagesEndpoint        = "/messages/inbound/";
    private final String outboundStatsEndpoint          = "/stats/outbound/";
    private final String triggerTagsEndpoint            = "/triggers/tags/";
    private final String triggerInboundRulesEndpoint    = "/triggers/inboundRules/";
    private final String sendingEndpoint                = "/email/";

    public ApiClient(String baseUrl, MultivaluedMap<String, Object> headers) {
        super(baseUrl,headers);
    }

    public ApiClient(String baseUrl, MultivaluedMap<String, Object>  headers, boolean secureConnection) {
        super(baseUrl, headers, secureConnection);
    }

    /*
      Email message sending endpoints
     */

    public MessageResponse deliverMessage(Message data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(sendingEndpoint), data);
        return dataHandler.fromJson(response, MessageResponse.class);
    }

    public ArrayList<MessageResponse> deliverMessage(ArrayList<Message> data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(sendingEndpoint + "batch"), data);
        return dataHandler.fromJson(response, new TypeReference<ArrayList<MessageResponse>>() {});
    }

    /*
      Bounced messages endpoints
     */

    public DeliveryStats getDeliveryStats() throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl("/deliveryStats/"));
        return dataHandler.fromJson(response, DeliveryStats.class);
    }

    public Bounces getBounces(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(bouncesEndpoint + parameters));
        return dataHandler.fromJson(response, Bounces.class);
    }

    public Bounce getBounce(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(bouncesEndpoint + id));
        return dataHandler.fromJson(response, Bounce.class);
    }

    public BounceDump getBounceDump(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(bouncesEndpoint + id + "/dump"));
        return dataHandler.fromJson(response, BounceDump.class);
    }

    public String activateBounce(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(bouncesEndpoint + id + "/activate"));
    }

    public ArrayList getBounceTags() throws PostmarkException, IOException {
        return dataHandler.fromJson(execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(bouncesEndpoint + "tags")), ArrayList.class);
    }


    /*
      Template handling endpoints
     */

    public Template getTemplate(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(templatesEndpoint + id));
        return dataHandler.fromJson(response, Template.class);
    }

    public Template getTemplate(String alias) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(templatesEndpoint + alias));
        return dataHandler.fromJson(response, Template.class);
    }

    public BaseTemplate createTemplate(TemplateContent data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(templatesEndpoint), data);
        return dataHandler.fromJson(response, BaseTemplate.class);
    }

    public BaseTemplate setTemplate(Integer id, TemplateContent data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(templatesEndpoint + id), data);
        return dataHandler.fromJson(response, BaseTemplate.class);
    }

    public BaseTemplate setTemplate(String alias, TemplateContent data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(templatesEndpoint + alias), data);
        return dataHandler.fromJson(response, BaseTemplate.class);
    }

    public Templates getTemplates(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(templatesEndpoint + parameters));
        return dataHandler.fromJson(response, Templates.class);
    }

    public String deleteTemplate(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(templatesEndpoint + id));
    }

    public String deleteTemplate(String alias) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(templatesEndpoint + alias));
    }

    public TemplateValidation validateTemplate(TemplateToValidate data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(templatesEndpoint + "validate"), data);
        return dataHandler.fromJson(response, TemplateValidation.class);
    }

    /**
     * Old method for sending messages with templates.
     *
     * @deprecated use {@link #deliverMessageWithTemplate(TemplatedMessage)} ()} instead.
     */
    @Deprecated
    public MessageResponse deliverMessage(TemplatedMessage data) throws PostmarkException, IOException {
        return deliverMessageWithTemplate(data);
    }

    public MessageResponse deliverMessageWithTemplate(TemplatedMessage data) throws PostmarkException, IOException {
        setTemplateModelToObject(data);

        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(sendingEndpoint + "withTemplate"), data);
        return dataHandler.fromJson(response, MessageResponse.class);
    }

    public ArrayList<MessageResponse> deliverMessageWithTemplate(ArrayList<TemplatedMessage> data) throws PostmarkException, IOException {
        /*
          When sending array of emails with templates, additional top level field is used called "Messages".
          This introduces unnecessary difference between batch and batchWithTemplates endpoint in data model.
          To keep it simple, this additional level is added before executing batch send.
         */
        HashMap<String, ArrayList> dataToSend = new HashMap<>();
        dataToSend.put("Messages", data);

        for(TemplatedMessage templateMessage:data) { setTemplateModelToObject(templateMessage); }

        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(sendingEndpoint + "batchWithTemplates"), dataToSend);
        return dataHandler.fromJson(response, new TypeReference<ArrayList<MessageResponse>>() {});
    }

    private void setTemplateModelToObject(TemplatedMessage data) throws IOException {
        /*
          Since template models can be complex, it is allowed that template model is a String or Object.
          If it's a String, we will auto convert it to Object.
         */
        if (data.getTemplateModel().getClass() == String.class) {
            data.setTemplateModel(dataHandler.fromJson(data.getTemplateModel().toString(),Object.class));
        }
    }


    /*
      Server endpoints for managing Servers in account.
     */

    public Server getServer() throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(serverEndpoint));
        return dataHandler.fromJson(response, Server.class);
    }

    public Server setServer(Server data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(serverEndpoint), data);
        return dataHandler.fromJson(response, Server.class);
    }

    /*
      Messages endpoints
     */

    /*
      Outbound Messages
     */

    public OutboundMessages getMessages(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundMessagesEndpoint + parameters));
        return dataHandler.fromJson(response, OutboundMessages.class);
    }

    public OutboundMessageDetails getMessageDetails(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundMessagesEndpoint + id + "/details"));
        return dataHandler.fromJson(response, OutboundMessageDetails.class);
    }

    public OutboundMessageDump getMessageDump(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundMessagesEndpoint + id + "/dump"));
        return dataHandler.fromJson(response, OutboundMessageDump.class);
    }

    public OutboundMessageOpens getMessageOpens(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundMessagesEndpoint + "opens" + parameters));
        return dataHandler.fromJson(response, OutboundMessageOpens.class);
    }

    public OutboundMessageOpens getMessageOpens(String id, Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundMessagesEndpoint + "opens/" + id + parameters));
        return dataHandler.fromJson(response, OutboundMessageOpens.class);
    }

    public OutboundMessageClicks getMessageClicks(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundMessagesEndpoint + "clicks" + parameters));
        return dataHandler.fromJson(response, OutboundMessageClicks.class);
    }

    public OutboundMessageClicks getMessageClicks(String id, Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundMessagesEndpoint + "clicks/" + id + parameters));
        return dataHandler.fromJson(response, OutboundMessageClicks.class);
    }

    /*
      Inbound Messages
     */

    public InboundMessages getInboundMessages(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(inboundMessagesEndpoint + parameters));
        return dataHandler.fromJson(response, InboundMessages.class);
    }

    public InboundMessageDetails getInboundMessageDetails(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(inboundMessagesEndpoint + id + "/details"));
        return dataHandler.fromJson(response, InboundMessageDetails.class);
    }

    public String bypassInboundMessage(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(inboundMessagesEndpoint + id + "/bypass"));
        return dataHandler.fromJson(response, String.class);
    }

    public String retryFailedInboundMessage(String id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(inboundMessagesEndpoint + id + "/retry"));
        return dataHandler.fromJson(response, String.class);
    }

    /*
      Stats Endpoints
     */

    public OutboundStats getOutboundStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + parameters));
        return dataHandler.fromJson(response, OutboundStats.class);
    }

    public OutboundSendStats getOutboundSendStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "sends" + parameters));
        return dataHandler.fromJson(response, OutboundSendStats.class);
    }

    public OutboundBounceStats getOutboundBounceStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "bounces" + parameters));
        return dataHandler.fromJson(response, OutboundBounceStats.class);
    }

    public OutboundSpamStats getOutboundSpamStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "spam" + parameters));
        return dataHandler.fromJson(response, OutboundSpamStats.class);
    }

    public OutboundTrackedStats getOutboundTrackedStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "tracked" + parameters));
        return dataHandler.fromJson(response, OutboundTrackedStats.class);
    }

    public OutboundOpenStats getOutboundOpenStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "opens" + parameters));
        return dataHandler.fromJson(response, OutboundOpenStats.class);
    }

    public OutboundOpenPlatformStats getOutboundOpenPlatformStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "opens/platforms" + parameters));
        return dataHandler.fromJson(response, OutboundOpenPlatformStats.class);
    }

    public HashMap getOutboundOpenClientStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "opens/platforms" + parameters));
        return dataHandler.fromJson(response, HashMap.class);
    }

    public HashMap getOutboundOpenReadTimes(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "opens/readTimes" + parameters));
        return dataHandler.fromJson(response, HashMap.class);
    }

    public OutboundClickStats getOutboundClickStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "clicks" + parameters));
        return dataHandler.fromJson(response, OutboundClickStats.class);
    }

    public HashMap getOutboundClickBrowsersStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "clicks/browserfamilies" + parameters));
        return dataHandler.fromJson(response, HashMap.class);
    }

    public OutboundClickPlatformStats getOutboundClickPlatformStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "clicks/platforms" + parameters));
        return dataHandler.fromJson(response, OutboundClickPlatformStats.class);
    }

    public OutboundClickLocationStats getOutboundClickLocationStats(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(outboundStatsEndpoint + "clicks/location" + parameters));
        return dataHandler.fromJson(response, OutboundClickLocationStats.class);
    }


    /*
      Trigger Tags endpoints
     */

    public TagMatcher createTriggerTag(TagMatcher data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(triggerTagsEndpoint), data);
        return dataHandler.fromJson(response, TagMatcher.class);
    }

    public TagMatcher getTriggerTag(Integer id) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(triggerTagsEndpoint + id));
        return dataHandler.fromJson(response, TagMatcher.class);
    }

    public TagMatcher setTriggerTag(Integer id, TagMatcher data) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(triggerTagsEndpoint + id), data);
        return dataHandler.fromJson(response, TagMatcher.class);
    }

    public String deleteTriggerTag(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(triggerTagsEndpoint + id));
    }

    public TagMatchers getTriggerTags(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(triggerTagsEndpoint + parameters));
        return dataHandler.fromJson(response, TagMatchers.class);
    }


    /*
      Trigger Inbound Rules endpoints
     */

    public InboundRuleResponse createInboundRule(String rule) throws PostmarkException, IOException {
        InboundRule data = new InboundRule();
        data.setRule(rule);
        String response = execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(triggerInboundRulesEndpoint), data);
        return dataHandler.fromJson(response, InboundRuleResponse.class);
    }

    public String deleteInboundRule(Integer id) throws PostmarkException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(triggerInboundRulesEndpoint + id));
    }

    public InboundRules getInboundRules(Parameters parameters) throws PostmarkException, IOException {
        String response = execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(triggerInboundRulesEndpoint + parameters));
        return dataHandler.fromJson(response, InboundRules.class);
    }

}
