package com.qianjin.java.soa.xml;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hsr_zones_list")
public class HsrZonesList {

    @XmlElement(name = "number_of_periods", required = true)
    protected BigInteger numberOfPeriods;

    public BigInteger getNumberOfPeriods() {
        return numberOfPeriods;
    }

    public void setNumberOfPeriods(BigInteger value) {
        this.numberOfPeriods = value;
    }

}
