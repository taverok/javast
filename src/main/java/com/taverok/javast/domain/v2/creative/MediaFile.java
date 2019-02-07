package com.taverok.javast.domain.v2.creative;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class MediaFile {
    @NonNull
    @XmlAttribute
    private String delivery = "progressive";

//    @XmlAttribute
//    private int bitrate = 1500;

    @NonNull
    @XmlAttribute
    private int width = 1280;

    @NonNull
    @XmlAttribute
    private int height = 720;

    @NonNull
    @XmlAttribute
    private String type = "video/mp4";

    @XmlValue
    private String content;

    @XmlAttribute
    private boolean maintainAspectRatio  = true;

    @XmlAttribute
    private boolean scalable  = true;

    public MediaFile(String content, @NonNull int width, @NonNull int height) {
        this.width = width;
        this.height = height;
        this.content = content;
    }
}
