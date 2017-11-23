
package com.csgsystems.webservices.precisionemail._1;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendBatchPrecisionEmailRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendBatchPrecisionEmailRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Profile" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}ProfileType"/>
 *         &lt;element name="EmailTemplate" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}EmailTemplateType" minOccurs="0"/>
 *         &lt;element name="FTPServerEmailTemplate" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}FTPServerEmailTemplateType" minOccurs="0"/>
 *         &lt;element name="FileAttachments" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}FileListType" minOccurs="0"/>
 *         &lt;element name="DataInputFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="FTPServerDataInputFileName" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}FTPServerDataInputFileNameType" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}PriorityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendBatchPrecisionEmailRequestType", propOrder = {
    "profile",
    "emailTemplate",
    "ftpServerEmailTemplate",
    "fileAttachments",
    "dataInputFile",
    "ftpServerDataInputFileName",
    "priority"
})
public class SendBatchPrecisionEmailRequestType {

    @XmlElement(name = "Profile", required = true)
    protected String profile;
    @XmlElement(name = "EmailTemplate")
    protected String emailTemplate;
    @XmlElement(name = "FTPServerEmailTemplate")
    protected FTPServerEmailTemplateType ftpServerEmailTemplate;
    @XmlElement(name = "FileAttachments")
    protected FileListType fileAttachments;
    @XmlElement(name = "DataInputFile")
    @XmlMimeType("application/octet-stream")
    protected DataHandler dataInputFile;
    @XmlElement(name = "FTPServerDataInputFileName")
    protected String ftpServerDataInputFileName;
    @XmlElement(name = "Priority")
    protected String priority;

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
     * Gets the value of the ftpServerEmailTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link FTPServerEmailTemplateType }
     *     
     */
    public FTPServerEmailTemplateType getFTPServerEmailTemplate() {
        return ftpServerEmailTemplate;
    }

    /**
     * Sets the value of the ftpServerEmailTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link FTPServerEmailTemplateType }
     *     
     */
    public void setFTPServerEmailTemplate(FTPServerEmailTemplateType value) {
        this.ftpServerEmailTemplate = value;
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
     * Gets the value of the dataInputFile property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getDataInputFile() {
        return dataInputFile;
    }

    /**
     * Sets the value of the dataInputFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setDataInputFile(DataHandler value) {
        this.dataInputFile = value;
    }

    /**
     * Gets the value of the ftpServerDataInputFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTPServerDataInputFileName() {
        return ftpServerDataInputFileName;
    }

    /**
     * Sets the value of the ftpServerDataInputFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTPServerDataInputFileName(String value) {
        this.ftpServerDataInputFileName = value;
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

}
