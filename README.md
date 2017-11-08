# Postmark Java Library

This Java Library is the official wrapper for the [Postmark HTTP API](http://postmarkapp.com). Postmark allows you to send your application's emails with high delivery rates, including bounce/spam processing and detailed statistics. In addition, Postmark can parse incoming emails which are forwarded back to your application.

## Install the library

*TODO*

## Get a Postmark API token

There are two types of security tokens that can be used with Postmark: 

* Server API tokens
* Account API tokens 

Server API tokens are security tokens that allow you to send emails, check bounces and more for each server in your Postmark account.
Account API tokens are security tokens that allow you to manage account wide details like verified domains, sender signatures. Account API tokens are available only for admins.

In order to send emails using Postmark Java library, you will need a [Postmark](http://postmarkapp.com) account. 
If you don't have one please register at [https://account.postmarkapp.com/sign_up](https://account.postmarkapp.com/sign_up).

If you didn’t create any servers yet, please create one, proceed to the `Credentials` tab and copy a Server API token. 
API tokens should be frequently rotated for security reasons.

## Communicating with the API

Make sure you have a [sender signature](https://postmarkapp.com/signatures) for every From email address you specify.
Retrieve an instance of `Postmark.getApiClient(yourApiToken)` to start sending emails.

``` java
yourApiToken = 'xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx'
ApiClient client = Postmark.getApiClient(yourApiToken);
```

## Sending a HTML message

``` java

Message message = new Message(
    "sheldon@bigbangtheory.com", 
    "leonard@bigbangtheory.com",
    "Re: Come on, Sheldon. It will be fun.", 
    "That's what you said about the Green Lantern");
    
MessageResponse response = client.deliverMessage(message);
                                                                                                                                                            'movie. You were 114 minutes of wrong.'");
```

## Sending a HTML message with open tracking set

``` java

Message message = new Message(
    "sheldon@bigbangtheory.com", 
    "leonard@bigbangtheory.com",
    "Re: Come on, Sheldon. It will be fun.", 
    "That's what you said about the Green Lantern");
    
message.setTrackLinks(Message.TRACK_LINKS.HtmlAndText);    
    
client.deliverMessage(message);    
                                                                                                                                                            'movie. You were 114 minutes of wrong.'");
```

## Sending a HTML message with link tracking set

``` java

Message message = new Message(
    "sheldon@bigbangtheory.com", 
    "leonard@bigbangtheory.com",
    "Re: Come on, Sheldon. It will be fun.", 
    "That's what you said about the Green Lantern");
    
message.setTrackLinks(Message.TRACK_LINKS.HtmlAndText);    
    
client.deliverMessage(message);    
                                                                                                                                                            'movie. You were 114 minutes of wrong.'");
```

## Sending a HTML message with attachments

``` java

Message message = new Message(
    "sheldon@bigbangtheory.com", 
    "leonard@bigbangtheory.com",
    "Re: Come on, Sheldon. It will be fun.", 
    "That's what you said about the Green Lantern");
    
message.addAttachment("/Path/To/File/example.pdf");    
    
client.deliverMessage(message);    
                                                                                                                                                            'movie. You were 114 minutes of wrong.'");
```

## Sending a multipart message

``` java

Message message = new Message(
    "sheldon@bigbangtheory.com", 
    "leonard@bigbangtheory.com",
    "Re: Come on, Sheldon. It will be fun.", 
    "That's what you said about the Green Lantern - html",
    "That's what you said about the Green Lantern - text");
        
client.deliverMessage(message);    
                                                                                                                                                            'movie. You were 114 minutes of wrong.'");
```

## Tagging messages

``` java

Message message = new Message(
    "sheldon@bigbangtheory.com", 
    "leonard@bigbangtheory.com",
    "Re: Come on, Sheldon. It will be fun.", 
    "That's what you said about the Green Lantern",
    "That's what you said about the Green Lantern");

message.setTag("testTag");        
    
client.deliverMessage(message);    
                                                                                                                                                            'movie. You were 114 minutes of wrong.'");
```

## Sending to multiple recipients

*TODO*

## Sending a templated email

*TODO*

## Sending in batches

*TODO*



## Working with bounces

*TODO*

## Sending in batches



## Requirements

You will need a Postmark account, server and sender signature set up to use it. The library requires Java 8 or newer.

## Copyright

Copyright © 2017 Wildbit LLC. See LICENSE for details.