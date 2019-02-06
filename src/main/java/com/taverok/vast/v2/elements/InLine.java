package com.taverok.vast.v2.elements;

import com.taverok.vast.v2.elements.creative.Creative;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class InLine {
    private AdSystem adSystem;

    private String adTitle;

    private String description;

    private String impression;

//    @XmlElementWrapper(name="creatives")
    private List<Creative> creatives;

    public static InLine newWithDefaults(String impression){
        InLine inLine = new InLine();
        inLine.setAdSystem(AdSystem.builder().version("1.0.0").content("AdServer").build());
        inLine.setAdTitle("Advertisement");
        inLine.setImpression(impression);

        inLine.creatives = new ArrayList<>();

        return inLine;
    }

    public void addCreative(Creative c){
        if (null==creatives)
            creatives = new ArrayList<>();

        creatives.add(c);
    }
}
