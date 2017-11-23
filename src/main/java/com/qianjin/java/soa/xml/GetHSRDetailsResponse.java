
package com.qianjin.java.soa.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response", namespace = "http://api.csr.mind.com/getHSRDetails")
public class GetHSRDetailsResponse extends MINDResponse {

    @XmlElementWrapper(name = "hsr_zones_list", namespace = "http://api.csr.mind.com/getHSRDetails")
    @XmlElement(name = "hsr_zone", namespace = "http://api.csr.mind.com/getHSRDetails")
    protected List<GetHSRDetailsResponse.HsrZone> hsrZone;

    @Override
    public String toString() {
        return "GetHSRDetailsResponse [hsrZone=" + hsrZone + ", error=" + error + "]";
    }

    public List<GetHSRDetailsResponse.HsrZone> getHsrZone() {
        return hsrZone;
    }

    public void setHsrZone(List<GetHSRDetailsResponse.HsrZone> hsrZone) {
        this.hsrZone = hsrZone;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", namespace = "http://api.csr.mind.com/getHSRDetails", propOrder = {})
    public static class HsrZone {

        @XmlElement(name = "number_of_periods", required = true, namespace = "http://api.csr.mind.com/getHSRDetails")
        protected BigInteger numberOfPeriods;
        @XmlElement(name = "max_periods_to_charge", required = true, namespace = "http://api.csr.mind.com/getHSRDetails")
        protected BigInteger maxPeriodsToCharge;
        @XmlElement(name = "charge_per_period", namespace = "http://api.csr.mind.com/getHSRDetails")
        protected double chargePerPeriod;
        @XmlElement(name = "current_period_start", namespace = "http://api.csr.mind.com/getHSRDetails")
        protected String currentPeriodStart;
        @XmlAttribute(name = "code")
        protected String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public BigInteger getNumberOfPeriods() {
            return numberOfPeriods;
        }

        @Override
        public String toString() {
            return "HsrZone [numberOfPeriods=" + numberOfPeriods + ", maxPeriodsToCharge=" + maxPeriodsToCharge + ", chargePerPeriod=" + chargePerPeriod + ", currentPeriodStart="
                    + currentPeriodStart + ", code=" + code + "]";
        }

        public void setNumberOfPeriods(BigInteger value) {
            this.numberOfPeriods = value;
        }

        public BigInteger getMaxPeriodsToCharge() {
            return maxPeriodsToCharge;
        }

        public void setMaxPeriodsToCharge(BigInteger value) {
            this.maxPeriodsToCharge = value;
        }

        public double getChargePerPeriod() {
            return chargePerPeriod;
        }

        public void setChargePerPeriod(double value) {
            this.chargePerPeriod = value;
        }

        public String getCurrentPeriodStart() {
            return currentPeriodStart;
        }

        public void setCurrentPeriodStart(String value) {
            this.currentPeriodStart = value;
        }

    }

}
