package com.taverok.javast.domain.v2.creative;

import com.taverok.javast.domain.v2.event.TrackingEvent;
import com.taverok.javast.domain.v2.event.click.ClickThrough;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class Creative {
    @XmlAttribute
    private String id;

    @Setter
    @XmlAttribute
    private int sequence;

    @XmlElement(name = "Linear")
    private Linear linear;

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


    public Creative addMedia(MediaFile m){
        linear.getMediaFiles().add(m);

        return this;
    }

    public Creative addMedia(String url, int width, int height){
        addMedia(new MediaFile(url, width, height));

        return this;
    }

    public Creative addMedias(List<String> urls, int width, int height){
        urls.forEach(e -> addMedia(e, width, height));

        return this;
    }
}
