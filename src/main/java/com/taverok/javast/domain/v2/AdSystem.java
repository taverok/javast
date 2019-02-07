package com.taverok.javast.domain.v2;

import lombok.Builder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@Builder
public class AdSystem {
    @XmlAttribute
    private String version;

    @XmlValue
    private String content;
}
