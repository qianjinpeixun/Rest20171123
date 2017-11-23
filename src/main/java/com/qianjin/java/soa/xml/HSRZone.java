package com.qianjin.java.soa.xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hsr_zone", propOrder = { "code", "number_of_periods", "max_periods_to_charge", "charge_per_period", "current_period_start" })
public class HSRZone {
    @XmlAttribute(name = "code", required = true)
    protected String code;
    @XmlElement(name = "number_of_periods", required = true)
    protected int number_of_periods;
    @XmlElement(name = "max_periods_to_charge", required = true)
    protected int max_periods_to_charge;
    @XmlElement(name = "charge_per_period", required = true)
    protected double charge_per_period;
    @XmlElement(name = "current_period_start", required = true)
    protected String current_period_start;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber_of_periods() {
        return number_of_periods;
    }

    public void setNumber_of_periods(int number_of_periods) {
        this.number_of_periods = number_of_periods;
    }

    public int getMax_periods_to_charge() {
        return max_periods_to_charge;
    }

    public void setMax_periods_to_charge(int max_periods_to_charge) {
        this.max_periods_to_charge = max_periods_to_charge;
    }

    public double getCharge_per_period() {
        return charge_per_period;
    }

    public void setCharge_per_period(double charge_per_period) {
        this.charge_per_period = charge_per_period;
    }

    public String getCurrent_period_start() {
        return current_period_start;
    }

    public void setCurrent_period_start(String current_period_start) {
        this.current_period_start = current_period_start;
    }

    @Override
    public String toString() {
        return "HSRZone [code=" + code + ", number_of_periods=" + number_of_periods + ", max_periods_to_charge=" + max_periods_to_charge + ", charge_per_period="
                + charge_per_period + ", current_period_start=" + current_period_start + "]";
    }

}