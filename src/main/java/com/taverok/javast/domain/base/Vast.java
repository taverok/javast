package com.taverok.javast.domain.base;


import lombok.*;
import javax.xml.bind.annotation.*;


@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "VAST")
public class Vast {
    @NonNull
    @XmlAttribute(name = "version")
    protected String version;

    @XmlElement(name = "Ad")
    protected Ad ad;

    @XmlElement(name = "Error")
    protected String error;

    {
        version="2.0";
    }

    public Ad newAd(String id){
        ad = new Ad(id);
        return ad;
    }

    public Vast noAds(){
        return this;
    }
}
