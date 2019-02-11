package com.taverok.javast.domain.v2;


import lombok.*;
import javax.xml.bind.annotation.*;


@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "VAST")
public class Vast {
    @NonNull
    @XmlAttribute(name = "version")
    private String versionStr;

    @XmlTransient
    private Versions version;

    @XmlElement(name = "Ad")
    private Ad ad;

    @XmlElement(name = "Error")
    private String error;


    @Getter
    public enum Versions{
        V2_0(2.0), V3_0(3.0);

        private String str;
        private double num;

        Versions(double num) {
            this.str = String.format("%.1f", num);
            this.num = num;
        }
    }


    public Vast(Versions v) {
        this.versionStr = v.getStr();
        this.version = v;
    }


    public Ad newAd(String id){
        ad = new Ad(id);
        return ad;
    }

    public void noAds(){
        if (version.getNum() >= 3 )
            error("No ads");
    }


    public void error(String error){
        this.error = error;
    }
}
