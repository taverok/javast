package com.taverok.javast.domain.v2;

import com.taverok.javast.domain.v2.creative.Creative;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class InLine {
    @XmlElement(name = "AdSystem")
    private AdSystem adSystem;

    @XmlElement(name = "AdTitle")
    private String adTitle;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "Impression")
    private String impression;

    @XmlElementWrapper(name="Creatives")
    @XmlElement(name = "Creative")
    private List<Creative> creatives = new ArrayList<>();


    @XmlElement(name = "Error")
    private String error;

    public InLine addCreative(Creative c){
        c.setSequence(creatives.size()+1);
        creatives.add(c);

        return this;
    }

    public InLine addCreatives(List<Creative> list){
        list.forEach(this::addCreative);

        return this;
    }
}
