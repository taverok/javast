package com.taverok.javast.domain.base.event;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TrackingEvent {
    @XmlAttribute(name = "event")
    private String eventAttr;
    @XmlValue
    private String content;

    public TrackingEvent(Events event, String content) {
        this.eventAttr = event.getEventAttr();
        this.content = content;
    }

    public enum Events{
        CREATIVE_VIEW("creativeView"),
        START("start"),
        MIDPOINT("midpoint"),
        FIRST_QUARTILE("firstQuartile"),
        THIRD_QUARTILE("thirdQuartile"),
        COMPLETE("complete"),
        MUTE("mute"),
        UNMUTE("unmute"),
        PAUSE("pause"),
        REWIND("rewind"),
        RESUME("resume"),
        FULLSCREEN("fullscreen"),
        EXPAND("expand"),
        COLLAPSE("collapse"),
        ACCEPT_INVITATION("acceptInvitation"),
        CLOSE("close");

        private String eventAttr;

        Events(String eventAttr) {
            this.eventAttr=eventAttr;
        }

        public String getEventAttr() {
            return eventAttr;
        }
    }
}
