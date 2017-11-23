
package com.csgsystems.webservices.precisionemail._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       	Bundled email entry.
 *     
 * 
 * <p>Java class for BundledEmailListEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BundledEmailListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubscriberKey" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}SubscriberKeyType"/>
 *         &lt;element name="EmailAddress" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}EmailAddressType"/>
 *         &lt;element name="EmailAttributes" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}EmailAttributeListType" minOccurs="0"/>
 *         &lt;element name="FileAttachments" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}FileListType" minOccurs="0"/>
 *         &lt;element name="URLAttachments" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}URLAttachmentListType" minOccurs="0"/>
 *         &lt;element name="FTPServerFileAttachments" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}FTPServerFileListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BundledEmailListEntry", propOrder = {
    "subscriberKey",
    "emailAddress",
    "emailAttributes",
    "fileAttachments",
    "urlAttachments",
    "ftpServerFileAttachments"
})
public class BundledEmailListEntry {

    @XmlElement(name = "SubscriberKey", required = true)
    protected String subscriberKey;
    @XmlElement(name = "EmailAddress", required = true)
    protected String emailAddress;
    @XmlElement(name = "EmailAttributes")
    protected EmailAttributeListType emailAttributes;
    @XmlElement(name = "FileAttachments")
    protected FileListType fileAttachments;
    @XmlElement(name = "URLAttachments")
    protected URLAttachmentListType urlAttachments;
    @XmlElement(name = "FTPServerFileAttachments")
    protected FTPServerFileListType ftpServerFileAttachments;

    /**
     * Gets the value of the subscriberKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberKey() {
        return subscriberKey;
    }

    /**
     * Sets the value of the subscriberKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberKey(String value) {
        this.subscriberKey = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
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
     * Gets the value of the fileAttachments property.
     * 
     * @return
     *     possible object is
     *     {@link FileListType }
     *     
     */
    public FileListType getFileAttachments() {
        return fileAttachments;
    }

    /**
     * Sets the value of the fileAttachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileListType }
     *     
     */
    public void setFileAttachments(FileListType value) {
        this.fileAttachments = value;
    }

    /**
     * Gets the value of the urlAttachments property.
     * 
     * @return
     *     possible object is
     *     {@link URLAttachmentListType }
     *     
     */
    public URLAttachmentListType getURLAttachments() {
        return urlAttachments;
    }

    /**
     * Sets the value of the urlAttachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link URLAttachmentListType }
     *     
     */
    public void setURLAttachments(URLAttachmentListType value) {
        this.urlAttachments = value;
    }

    /**
     * Gets the value of the ftpServerFileAttachments property.
     * 
     * @return
     *     possible object is
     *     {@link FTPServerFileListType }
     *     
     */
    public FTPServerFileListType getFTPServerFileAttachments() {
        return ftpServerFileAttachments;
    }

    /**
     * Sets the value of the ftpServerFileAttachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link FTPServerFileListType }
     *     
     */
    public void setFTPServerFileAttachments(FTPServerFileListType value) {
        this.ftpServerFileAttachments = value;
    }

}
