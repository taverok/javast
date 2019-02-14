package com.taverok.javast.domain.base.creative;

import com.taverok.javast.domain.Version;
import com.taverok.javast.domain.base.event.TrackingEvent;
import com.taverok.javast.domain.base.event.click.VideoClicks;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
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

    @XmlAttribute(name = "skipoffset")
    private String skipoffset;

    public Linear() {
        trackingEvents = new ArrayList<>();
        videoClicks = new VideoClicks();
        mediaFiles = new ArrayList<>();
    }

    public Linear(String duration){
        this();
        this.duration = duration;
    }

    public Linear setSkipoffset(String s, Version version) {
        if (version.getNum() > 2)
            skipoffset = s;

        return this;
    }
}
