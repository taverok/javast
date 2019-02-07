package com.taverok.javast.domain.v2;


import lombok.*;
import javax.xml.bind.annotation.*;


@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "VAST")
public class Vast {
    @XmlAttribute
    @NonNull
    private String version;

    @XmlElement(name = "Ad")
    private Ad ad;

    public Vast(String version) {
        this.version = version;
    }

    public Ad newAd(String id){
        this.ad = new Ad(id);

        return this.ad;
    }

    public Ad newAd(){
        this.ad = new Ad("00001");

        return this.ad;
    }
}
