
package com.csgsystems.webservices.precisionemail._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       These are name value pairs of batch meta data.
 *     
 * 
 * <p>Java class for BatchDetailListEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchDetailListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchDetailName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BatchDetailValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchDetailListEntry", propOrder = {
    "batchDetailName",
    "batchDetailValue"
})
public class BatchDetailListEntry {

    @XmlElement(name = "BatchDetailName", required = true)
    protected String batchDetailName;
    @XmlElement(name = "BatchDetailValue", required = true)
    protected String batchDetailValue;

    /**
     * Gets the value of the batchDetailName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchDetailName() {
        return batchDetailName;
    }

    /**
     * Sets the value of the batchDetailName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchDetailName(String value) {
        this.batchDetailName = value;
    }

    /**
     * Gets the value of the batchDetailValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchDetailValue() {
        return batchDetailValue;
    }

    /**
     * Sets the value of the batchDetailValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchDetailValue(String value) {
        this.batchDetailValue = value;
    }

}
