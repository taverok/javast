package com.taverok.vast.v2.elements.creative;

import lombok.Builder;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Creative {
    @XmlAttribute
    private String id;

    @XmlAttribute
    private int sequence;

    @XmlElement(name = "Linear")
    private final Linear linear = new Linear();
}
