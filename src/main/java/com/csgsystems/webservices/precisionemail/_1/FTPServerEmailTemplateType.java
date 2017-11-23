
package com.csgsystems.webservices.precisionemail._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       This references a file that contains an email template on a ftp server.  Must reference the filename, and the subject of the new email template.
 *     
 * 
 * <p>Java class for FTPServerEmailTemplateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FTPServerEmailTemplateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TextOnly" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HTMLFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FTPServerEmailTemplateType", propOrder = {
    "textOnly",
    "fileName",
    "htmlFileName",
    "subject"
})
public class FTPServerEmailTemplateType {

    @XmlElement(name = "TextOnly")
    protected String textOnly;
    @XmlElement(name = "FileName", required = true)
    protected String fileName;
    @XmlElement(name = "HTMLFileName")
    protected String htmlFileName;
    @XmlElement(name = "Subject", required = true)
    protected String subject;

    /**
     * Gets the value of the textOnly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextOnly() {
        return textOnly;
    }

    /**
     * Sets the value of the textOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextOnly(String value) {
        this.textOnly = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the htmlFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTMLFileName() {
        return htmlFileName;
    }

    /**
     * Sets the value of the htmlFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTMLFileName(String value) {
        this.htmlFileName = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

}
