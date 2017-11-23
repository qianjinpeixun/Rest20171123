
package com.csgsystems.webservices.precisionemail._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       	An Event
 *     
 * 
 * <p>Java class for EventListEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EventData" type="{http://webservices.csgsystems.com/PrecisionEmail/1.0}EventDataType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventListEntry", propOrder = {
    "eventData"
})
public class EventListEntry {

    @XmlElement(name = "EventData", required = true)
    protected List<EventDataType> eventData;

    /**
     * Gets the value of the eventData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventDataType }
     * 
     * 
     */
    public List<EventDataType> getEventData() {
        if (eventData == null) {
            eventData = new ArrayList<EventDataType>();
        }
        return this.eventData;
    }

}
