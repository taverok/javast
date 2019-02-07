package com.taverok.javast.domain.v2.event.click;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoClicks {
    @XmlElement(name = "ClickThrough")
    private ClickThrough clickThrough;
}
