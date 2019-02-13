package com.taverok.javast.domain.base.creative;

import com.taverok.javast.domain.base.event.TrackingEvent;
import com.taverok.javast.domain.base.event.click.VideoClicks;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class Linear {
    @XmlElement(name = "Duration")
    private String duration;

    @XmlElementWrapper(name = "TrackingEvents")
    @XmlElement(name = "Tracking")
    private List<TrackingEvent> trackingEvents;

    @XmlElement(name = "VideoClicks")
    private VideoClicks videoClicks;

    @XmlElementWrapper(name = "MediaFiles")
    @XmlElement(name = "MediaFile")
    private List<MediaFile> mediaFiles;

    public Linear() {
        trackingEvents = new ArrayList<>();
        videoClicks = new VideoClicks();
        mediaFiles = new ArrayList<>();
    }

    public Linear(String duration){
        this();
        this.duration = duration;
    }
}
