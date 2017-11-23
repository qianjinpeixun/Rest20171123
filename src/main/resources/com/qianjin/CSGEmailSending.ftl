<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="http://webservices.csgsystems.com/PrecisionEmail/1.0">
   <soapenv:Header><wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"><wsu:Timestamp wsu:Id="TS-2E829783C7B05DF81F151031831970454"><wsu:Created>2017-11-10T12:51:59Z</wsu:Created><wsu:Expires>2017-11-10T14:31:59Z</wsu:Expires></wsu:Timestamp><wsse:UsernameToken wsu:Id="UsernameToken-2E829783C7B05DF81F151031831970453"><wsse:Username>estlk</wsse:Username><wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest">dcnRlF44CdL9b1kQFJQp5BpMgSE=</wsse:Password><wsse:Nonce EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary">HU9isA61h1Oa41Juvl7E3g==</wsse:Nonce><wsu:Created>2017-11-10T12:51:59.704Z</wsu:Created></wsse:UsernameToken></wsse:Security></soapenv:Header>
   <soapenv:Body>

<SendTriggerPrecisionEmailRequest>
                    <Profile>estlk</Profile>
                    <EmailTemplate>estlk_CRTC_Roaming</EmailTemplate>
                    <SubscriberKey>${SubscriberKey!?string}</SubscriberKey>
                    <EmailAddress>${email!?string}</EmailAddress>
                    <EmailAttributes>
                           <EmailAttribute>
                                 <AttributeName>First Name</AttributeName>
                                 <AttributeValue>${firstname!?string}</AttributeValue>
                           </EmailAttribute>
                           <EmailAttribute>
                                 <AttributeName>Phone Number</AttributeName>
                                 <AttributeValue>${ani!?string}</AttributeValue>
                           </EmailAttribute>
                           <EmailAttribute>
                                 <AttributeName>Country</AttributeName>
                                 <AttributeValue>${country!?string}</AttributeValue>
                           </EmailAttribute>
                           <EmailAttribute>
                                 <AttributeName>Rate Per Minute</AttributeName>
                                 <AttributeValue>${rate_minute!?string}</AttributeValue>
                           </EmailAttribute>
                           <EmailAttribute>
                                 <AttributeName>Rate Per MB</AttributeName>
                                 <AttributeValue>${rate_mb!?string}</AttributeValue>
                           </EmailAttribute>
                           <EmailAttribute>
                                 <AttributeName>Rate Per SMS</AttributeName>
                                 <AttributeValue>${rate_sms!?string}</AttributeValue>
                           </EmailAttribute>
                    </EmailAttributes>
             </SendTriggerPrecisionEmailRequest>
               </soapenv:Body>
</soapenv:Envelope>