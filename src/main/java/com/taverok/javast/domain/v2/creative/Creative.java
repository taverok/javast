package com.taverok.javast.domain.v2.creative;

import com.taverok.javast.domain.v2.event.TrackingEvent;
import com.taverok.javast.domain.v2.event.click.ClickThrough;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class Creative {
    @XmlAttribute
    private String id;

    @Setter
    @XmlAttribute
    private int sequence;

    @XmlElement(name = "Linear")
    private final Linear linear;

    public Creative(String id, String duration) {
        this.id = id;
        linear = new Linear(duration);
    }

    public Creative addTrackingCallback(TrackingEvent.Events event, String url){
        linear.getTrackingEvents().add(new TrackingEvent(event, url));

        return this;
    }

    public Creative addClickCallback(String url){
        linear.getVideoClicks().setClickThrough(new ClickThrough(url));

        return this;
    }
}