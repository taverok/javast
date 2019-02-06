package com.taverok.vast.v2.elements;


import lombok.*;

import javax.xml.bind.annotation.*;


@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "VAST")
public class Vast {
    @XmlAttribute
    private String version;

    @XmlElement(name = "Ad")
    private Ad ad;
}
