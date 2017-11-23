
package com.csgsystems.webservices.precisionemail._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendTriggerBundlePrecisionEmailRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendTriggerBundlePrecisionEmailRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Profile" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}ProfileType"/>
 *         &lt;element name="EmailTemplate" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}EmailTemplateType"/>
 *         &lt;element name="ConversationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}PriorityType" minOccurs="0"/>
 *         &lt;element name="EmailAttributes" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}EmailAttributeListType" minOccurs="0"/>
 *         &lt;element name="BundledEmails" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}BundledEmailListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendTriggerBundlePrecisionEmailRequestType", propOrder = {
    "profile",
    "emailTemplate",
    "conversationId",
    "priority",
    "emailAttributes",
    "bundledEmails"
})
public class SendTriggerBundlePrecisionEmailRequestType {

    @XmlElement(name = "Profile", required = true)
    protected String profile;
    @XmlElement(name = "EmailTemplate", required = true)
    protected String emailTemplate;
    @XmlElement(name = "ConversationId")
    protected String conversationId;
    @XmlElement(name = "Priority")
    protected String priority;
    @XmlElement(name = "EmailAttributes")
    protected EmailAttributeListType emailAttributes;
    @XmlElement(name = "BundledEmails", required = true)
    protected BundledEmailListType bundledEmails;

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfile(String value) {
        this.profile = value;
    }

    /**
     * Gets the value of the emailTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailTemplate() {
        return emailTemplate;
    }

    /**
     * Sets the value of the emailTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailTemplate(String value) {
        this.emailTemplate = value;
    }

    /**
     * Gets the value of the conversationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * Sets the value of the conversationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversationId(String value) {
        this.conversationId = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Gets the value of the emailAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link EmailAttributeListType }
     *     
     */
    public EmailAttributeListType getEmailAttributes() {
        return emailAttributes;
    }

    /**
     * Sets the value of the emailAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailAttributeListType }
     *     
     */
    public void setEmailAttributes(EmailAttributeListType value) {
        this.emailAttributes = value;
    }

    /**
     * Gets the value of the bundledEmails property.
     * 
     * @return
     *     possible object is
     *     {@link BundledEmailListType }
     *     
     */
    public BundledEmailListType getBundledEmails() {
        return bundledEmails;
    }

    /**
     * Sets the value of the bundledEmails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BundledEmailListType }
     *     
     */
    public void setBundledEmails(BundledEmailListType value) {
        this.bundledEmails = value;
    }

}
