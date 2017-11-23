
package com.csgsystems.webservices.precisionemail._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       The FileName is a string of your desired filename, such as PayYourBill.PDF, and the FTPServerFileName is the name of the file on the ftp server.
 *       For example, send bill.pdf as the FileName, and bill.pdf_2008_01_01_01_01_01_222_353344433 as the FTPServerFileName.  You then will get bill.pdf in the email.
 *     
 * 
 * <p>Java class for FTPServerFileListEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FTPServerFileListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FTPServerFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FTPServerFileListEntry", propOrder = {
    "fileName",
    "ftpServerFileName"
})
public class FTPServerFileListEntry {

    @XmlElement(name = "FileName", required = true)
    protected String fileName;
    @XmlElement(name = "FTPServerFileName", required = true)
    protected String ftpServerFileName;

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
     * Gets the value of the ftpServerFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTPServerFileName() {
        return ftpServerFileName;
    }

    /**
     * Sets the value of the ftpServerFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTPServerFileName(String value) {
        this.ftpServerFileName = value;
    }

}
