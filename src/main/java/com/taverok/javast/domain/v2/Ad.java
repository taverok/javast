package com.taverok.javast.domain.v2;

import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Ad {
    @XmlAttribute
    private String id;

    @XmlElement(name = "InLine")
    @NonNull
    private InLine inLine;

    public Ad(String id) {
        this.id = id;
    }

    public InLine newInline(String impressionUrl, String title, String adSystem){
        inLine = new InLine();
        inLine.setAdSystem(AdSystem.builder().version("1.0.0").content(adSystem).build());
        inLine.setAdTitle(title);
        inLine.setDescription(title);
        inLine.setImpression(impressionUrl);

        return inLine;
    }

    public void error(String error){
        inLine = new InLine();
        inLine.setError(error);
    }
}
