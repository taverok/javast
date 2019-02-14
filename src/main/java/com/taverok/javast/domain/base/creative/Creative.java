package com.taverok.javast.domain.base.creative;

import com.taverok.javast.domain.base.event.TrackingEvent;
import com.taverok.javast.domain.base.event.click.ClickThrough;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Creative {
    @XmlAttribute
    private String id;

    @Setter
    @XmlAttribute
    private int sequence;

    @XmlElement(name = "Linear")
    private Linear linear;

    public Creative(String id) {
        this.id = id;
    }

    public static Creative newLinear(String id, String duration) {
        Creative creative = new Creative(id);
        creative.linear = new Linear(duration);

        return creative;
    }

    public Creative addTrackingCallback(TrackingEvent.Events event, String url){
        linear.getTrackingEvents().add(new TrackingEvent(event, url));

        return this;
    }

    public Creative addClickThrough(String url){
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
