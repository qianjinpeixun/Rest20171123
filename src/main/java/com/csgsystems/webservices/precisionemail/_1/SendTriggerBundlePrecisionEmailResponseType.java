
package com.csgsystems.webservices.precisionemail._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendTriggerBundlePrecisionEmailResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendTriggerBundlePrecisionEmailResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TriggeredEmailStatuses" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}TriggeredEmailStatusListType" minOccurs="0"/>
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TaskIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendTriggerBundlePrecisionEmailResponseType", propOrder = {
    "triggeredEmailStatuses",
    "returnCode",
    "taskIdentifier"
})
public class SendTriggerBundlePrecisionEmailResponseType {

    @XmlElement(name = "TriggeredEmailStatuses")
    protected TriggeredEmailStatusListType triggeredEmailStatuses;
    @XmlElement(name = "ReturnCode", required = true)
    protected String returnCode;
    @XmlElement(name = "TaskIdentifier", required = true)
    protected String taskIdentifier;

    /**
     * Gets the value of the triggeredEmailStatuses property.
     * 
     * @return
     *     possible object is
     *     {@link TriggeredEmailStatusListType }
     *     
     */
    public TriggeredEmailStatusListType getTriggeredEmailStatuses() {
        return triggeredEmailStatuses;
    }

    /**
     * Sets the value of the triggeredEmailStatuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggeredEmailStatusListType }
     *     
     */
    public void setTriggeredEmailStatuses(TriggeredEmailStatusListType value) {
        this.triggeredEmailStatuses = value;
    }

    /**
     * Gets the value of the returnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnCode(String value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the taskIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskIdentifier() {
        return taskIdentifier;
    }

    /**
     * Sets the value of the taskIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskIdentifier(String value) {
        this.taskIdentifier = value;
    }

}
