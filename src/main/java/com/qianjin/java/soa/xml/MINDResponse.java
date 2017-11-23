package com.qianjin.java.soa.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public abstract class MINDResponse {
    
    @Override
    public String toString() {
        return "MINDResponse [error=" + error + ", returnCode=" + returnCode + ", messageBuffer=" + messageBuffer + "]";
    }

    @XmlElement(name="error")
    public MINDError error;

    public MINDError getError() {
        return error;
    }

    public void setError(MINDError error) {
        this.error = error;
    }

    @XmlElement(name="returncode")
    private Integer returnCode = 0;
    
    @XmlElement
    private String messageBuffer = "Success";

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessageBuffer() {
        return messageBuffer;
    }

    public void setMessageBuffer(String messageBuffer) {
        this.messageBuffer = messageBuffer;
    }
}
