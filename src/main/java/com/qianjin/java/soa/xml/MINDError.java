package com.qianjin.java.soa.xml;


import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MINDError {
        
        @XmlAttribute(name = "charge")
        protected Double charge;
        @XmlAttribute(name = "curr_alpha_code")
        protected String currAlphaCode;
        @XmlAttribute(name = "currency_symbol")
        protected String currencySymbol;
        @XmlAttribute(name = "currency_precision")
        protected BigInteger currencyPrecision;
        
        public Double getCharge() {
            return charge;
        }

        public void setCharge(Double charge) {
            this.charge = charge;
        }

        public String getCurrAlphaCode() {
            return currAlphaCode;
        }

        public void setCurrAlphaCode(String currAlphaCode) {
            this.currAlphaCode = currAlphaCode;
        }

        public String getCurrencySymbol() {
            return currencySymbol;
        }

        public void setCurrencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
        }

        public BigInteger getCurrencyPrecision() {
            return currencyPrecision;
        }

        public void setCurrencyPrecision(BigInteger currencyPrecision) {
            this.currencyPrecision = currencyPrecision;
        }
        
        @XmlElement(required = true)
        protected Integer code;
        @XmlElement(required = true)
        protected String message;
        
        public Integer getCode() {
            return code;
        }
    
        
        public void setCode(Integer value) {
            this.code = value;
        }
    
        
        @Override
        public String toString() {
            return "MINDError [charge=" + charge + ", currAlphaCode=" + currAlphaCode + ", currencySymbol=" + currencySymbol + ", currencyPrecision=" + currencyPrecision
                    + ", code=" + code + ", message=" + message + "]";
        }

        public String getMessage() {
            return message;
        }
    
        
        public void setMessage(String value) {
            this.message = value;
        }
    
    }

