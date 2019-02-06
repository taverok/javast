package com.taverok.vast.v2.elements;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Ad {
    @XmlAttribute
    private String id;

    @XmlElement(name = "InLine")
    private InLine inLine;

    public static Ad newInline(String id, String impression){
        Ad ad = new Ad();
        ad.id = id;
        ad.inLine = InLine.newWithDefaults(impression);

        return ad;
    }
}
