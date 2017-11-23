
package com.csgsystems.webservices.precisionemail._1;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       The FileName is a string of your desired filename, such as PayYourBill.PDF, and the PhysicalFile is a MTOM Attachment (MTOM sent in chunks is MANDATORY) to transfer as binary data.
 *       For example, send bill.pdf as the FileName, and then stream the file binary.  You then will get bill.pdf in the email.
 *     
 * 
 * <p>Java class for FileListEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PhysicalFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileListEntry", propOrder = {
    "fileName",
    "physicalFile"
})
public class FileListEntry {

    @XmlElement(name = "FileName", required = true)
    protected String fileName;
    @XmlElement(name = "PhysicalFile", required = true)
    @XmlMimeType("application/octet-stream")
    protected DataHandler physicalFile;

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
     * Gets the value of the physicalFile property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getPhysicalFile() {
        return physicalFile;
    }

    /**
     * Sets the value of the physicalFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setPhysicalFile(DataHandler value) {
        this.physicalFile = value;
    }

}
