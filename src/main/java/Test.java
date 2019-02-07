import com.taverok.javast.domain.v2.creative.Creative;
import com.taverok.javast.domain.v2.Vast;
import com.taverok.javast.service.XmlService;

import java.util.Arrays;

import static com.taverok.javast.domain.v2.event.TrackingEvent.Events.*;


public class Test {
    public static void main(String[] args) {

        Creative creative = new Creative("prerollId", "00:00:15")
                .addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
                .addClickCallback("http://clickUrl");
        Creative anotherCreative = new Creative("prerollId", "00:00:15")
                .addTrackingCallback(START, "http://playUrl")
                .addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
                .addTrackingCallback(PAUSE, "http://playUrl")
                .addClickCallback("http://clickUrl");

        Vast vast = new Vast("2.0");
        vast.newAd()
                .newInline("http://impressionUrl", "Advertisement", "AdService")
                .addCreative(creative)
                .addCreatives(Arrays.asList(creative, anotherCreative));

        XmlService xmlService = new XmlService();
        String xml = xmlService.getXml(vast);
        System.out.println(xml);
    }
}
