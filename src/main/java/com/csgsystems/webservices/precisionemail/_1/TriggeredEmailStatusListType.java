
package com.csgsystems.webservices.precisionemail._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TriggeredEmailStatusListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TriggeredEmailStatusListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TriggeredEmailStatus" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}TriggeredEmailStatusListEntry" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TriggeredEmailStatusListType", propOrder = {
    "triggeredEmailStatus"
})
public class TriggeredEmailStatusListType {

    @XmlElement(name = "TriggeredEmailStatus", required = true)
    protected List<TriggeredEmailStatusListEntry> triggeredEmailStatus;

    /**
     * Gets the value of the triggeredEmailStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the triggeredEmailStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTriggeredEmailStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TriggeredEmailStatusListEntry }
     * 
     * 
     */
    public List<TriggeredEmailStatusListEntry> getTriggeredEmailStatus() {
        if (triggeredEmailStatus == null) {
            triggeredEmailStatus = new ArrayList<TriggeredEmailStatusListEntry>();
        }
        return this.triggeredEmailStatus;
    }

}
