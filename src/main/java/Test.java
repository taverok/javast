import com.taverok.vast.v2.elements.Ad;
import com.taverok.vast.v2.elements.creative.Creative;
import com.taverok.vast.v2.elements.Vast;
import com.taverok.vast.service.XmlService;
import com.taverok.vast.v2.elements.events.TrackingEvent;

import java.util.Arrays;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        XmlService xmlService = new XmlService();

        Ad ad = Ad.newInline("42343242", "http://somelink.test");

        List<TrackingEvent> trackingEvents = Arrays.asList(
                new TrackingEvent(TrackingEvent.Events.FIRST_QUARTILE.getEventAttr(), "showUrl")
        );

        Creative creative = Creative.builder().id("Preroll_id").sequence(1).build();
        creative.getLinear().setTrackingEvents(trackingEvents);
        ad.getInLine().addCreative(creative);

        Vast vast = Vast.builder().version("2.0").ad(ad).build();
        String xml = xmlService.getXml(vast);
        System.out.println(xml);
    }
}
