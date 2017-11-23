
package com.csgsystems.webservices.precisionemail._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FTPServerFileListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FTPServerFileListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FTPServerFile" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}FTPServerFileListEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FTPServerFileListType", propOrder = {
    "ftpServerFile"
})
public class FTPServerFileListType {

    @XmlElement(name = "FTPServerFile")
    protected List<FTPServerFileListEntry> ftpServerFile;

    /**
     * Gets the value of the ftpServerFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftpServerFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTPServerFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FTPServerFileListEntry }
     * 
     * 
     */
    public List<FTPServerFileListEntry> getFTPServerFile() {
        if (ftpServerFile == null) {
            ftpServerFile = new ArrayList<FTPServerFileListEntry>();
        }
        return this.ftpServerFile;
    }

}
