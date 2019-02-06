package com.taverok.vast.v2.elements.creative;

import com.taverok.vast.v2.elements.events.TrackingEvent;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Linear {
    private String duration;

    @XmlElementWrapper(name = "TrackingEvents")
    private List<TrackingEvent> trackingEvents;
}
