import com.taverok.javast.domain.v2.creative.Creative;
import com.taverok.javast.domain.v2.Vast;
import com.taverok.javast.service.XmlService;

import static com.taverok.javast.domain.v2.Vast.Versions.*;
import static com.taverok.javast.domain.v2.event.TrackingEvent.Events.*;


public class Test {
    public static void main(String[] args) {

        Creative creative = new Creative("prerollId", "00:00:15")
                .addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
                .addClickCallback("http://clickUrl")
                .addMedia("http://mediaUrl", 1280, 720);

        Vast vast = new Vast(V2_0);
        vast.newAd("122222")
                .newInline("http://impressionUrl", "Advertisement", "AdService")
                .addCreative(creative);

        XmlService xmlService = new XmlService();
        String xml = xmlService.getXml(vast);
        System.out.println(xml);
    }
}
