# Changelog

## 1.7.4

* fixed server data model
* added more documentation to the library 

## 1.7.3

* update package to use for mime
* use only core of the apache tika

## 1.7.2           

* switched to default java logging
* switched from mimeutil library to apache tika for file type detection
* small type updates

## 1.7.0           

* removed jaxb bindings
* updated log library
* added more message creation tests
* updated jersey version to 2.33

## 1.5.7           

* small model update

## 1.5.6           

* clients can be retrieved with custom API url now

## 1.5.5           

* remove obsolete test

## 1.5.3           

* Errors that come from Postmark API will contain error code from now on
* Error handler is separated from http client handler
* Message details endpoint supports parameters usage

## 1.5.2           

* sending has an option to choose message stream now
* fixed issue with templates not having option to attach files with content id (used mostly for inline images)

## 1.5.0           

* updated jersey version and Bounce ID to long type

## 1.2.4           

* bounce tag endpoint is no longer supported

## 1.2.3           

* fixed Jackson 2.10.0 library with Java 11 usage

## 1.2.2           

* added webhook management support
* improved test coverage
* improved type model

## 1.2.1           

* updated jackson version to resolve security issue
* added template layouts support
* fix date deserializing issue with some of the inbound messages

## 1.2.0           

* tiny update to dependency model for Jackson

## 1.1.9           

* added template pushes support

## 1.1.8           

* add support for using metadata to sending email with template

## 1.1.6           

* updated message model to new metadata format

## 1.1.5           

* updated version - for easy backporting to jersey1x for users using old version of jersey

## 1.1.4           

* disable logging by default, allow users to customize it

## 1.1.3           

* improved adding attachments for templates endpoint

## 1.1.2           

* better support for adding attachments to email message

## 1.1.1           

* force jackson annotations to be the same as jackson provider

## 1.1             

* added verifyDomainDKIM endpoint to client
* added verifyDomainReturnPath endpoint to client
* template feature updates
* added support for managing templates by Alias
* added support for batch sending templates
* model for bounces, opens, clicks, delivery updated with "RecordType" support
* inbound webhooks have "rawEmail" support now
* updated Jackson (JSON object handler) to latest stable version (2.9.5) - this should resolve parsing issues with "fractional" timezones
* object model changed to use interfaces instead of implementations for lists and maps
* deprecated "deliverMessage" API client call for templates, use "deliverMessageWithTemplate" instead
* added new integration tests

## 1.0.5           

* added support for boolean parameters

## 1.0.4           

* added separate inbound object for webhook for clearer naming

## 1.0.2           

* fixed link tracking constant values

## 1.0.1           

* small fix in object serilization:

## 1.0.0           

* official first release