package com.taverok.javast.domain.base.creative;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class MediaFile {
    @XmlAttribute
    private String delivery = "progressive";

//    @XmlAttribute
//    private int bitrate = 1500;

    @XmlAttribute
    private int width = 1280;

    @XmlAttribute
    private int height = 720;

    @XmlAttribute
    private String type = "video/mp4";

    @XmlValue
    private String content;

    @XmlAttribute
    private boolean maintainAspectRatio  = true;

    @XmlAttribute
    private boolean scalable  = true;

    public MediaFile(String content, int width, int height) {
        this.width = width;
        this.height = height;
        this.content = content;
    }
}
