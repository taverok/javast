package com.taverok.vast.v2.elements.events;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "Tracking")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrackingEvent {
    @XmlAttribute(name = "event")
    private String event;
    @XmlValue
    private String content;
}
