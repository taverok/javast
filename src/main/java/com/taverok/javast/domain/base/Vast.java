package com.taverok.javast.domain.base;


import com.taverok.javast.domain.Version;
import lombok.*;
import javax.xml.bind.annotation.*;


@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "VAST")
public class Vast {
    @Getter
    @XmlTransient
    private Version ver;

    @NonNull
    @XmlAttribute(name = "version")
    protected String version;

    @XmlElement(name = "Ad")
    protected Ad ad;

    @XmlElement(name = "Error")
    protected String error;

    public Vast(Version ver) {
        this.ver = ver;
        this.version = ver.getStr();
    }

    public Ad newAd(String id){
        ad = new Ad(id);
        return ad;
    }

    public Vast noAds(){
        return this;
    }
}
