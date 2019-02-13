package com.taverok.javast.domain.base.extension;

import com.taverok.javast.domain.base.event.TrackingEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Extension {
    @XmlElementWrapper(name = "CustomTracking")
    @XmlElement(name = "Tracking")
    private List<TrackingEvent> trackingEvents;

    public Extension addCusctomCallback(TrackingEvent e){
        if(Objects.isNull(trackingEvents))
            trackingEvents=new ArrayList<>();

        trackingEvents.add(e);

        return this;
    }
}
