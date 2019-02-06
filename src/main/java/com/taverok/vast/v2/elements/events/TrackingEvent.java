package com.taverok.vast.v2.elements.events;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TrackingEvent {
    @XmlAttribute(name = "event")
    private String event;
    @XmlValue
    private String content;

    public enum Events{
        FIRST_QUARTILE("firstQuartile");

        private String eventAttr;

        Events(String eventAttr) {
            this.eventAttr=eventAttr;
        }

        public String getEventAttr() {
            return eventAttr;
        }
    }
}
