package com.taverok.javast;

import com.taverok.javast.domain.v2.Ad;
import com.taverok.javast.domain.v2.AdSystem;
import com.taverok.javast.domain.v2.InLine;
import com.taverok.javast.domain.v2.Vast;
import com.taverok.javast.domain.v2.creative.Creative;
import com.taverok.javast.domain.v2.creative.Linear;
import com.taverok.javast.domain.v2.creative.MediaFile;
import com.taverok.javast.domain.v2.event.TrackingEvent;
import com.taverok.javast.domain.v2.event.click.ClickThrough;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

import static com.taverok.javast.domain.v2.Vast.Versions.V2_0;
import static com.taverok.javast.domain.v2.event.TrackingEvent.Events.FIRST_QUARTILE;
import static org.junit.jupiter.api.Assertions.*;


public class V2SerializationTest {

    final String V2_SCHEMA_PATH = "vastV2.xml";
    File schemaFile;

    Vast originalVast = new Vast(V2_0);
    String adId = "testing_ad_123";

    Unmarshaller unmarshaller;
    Marshaller marshaller;


    @BeforeEach
    public void init() throws JAXBException, SAXException {
        schemaFile = new File(getClass().getClassLoader().getResource(V2_SCHEMA_PATH).getFile());

        Creative creative = new Creative("prerollId", "00:00:15")
                .addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
                .addClickCallback("http://clickUrl")
                .addMedia("http://mediaUrl", 1280, 720);
        originalVast.newAd(adId)
                .newInline("http://impressionUrl", "Advertisement", "AdService")
                .addCreative(creative);

        JAXBContext context = JAXBContext.newInstance(Vast.class);
        marshaller = context.createMarshaller();
        unmarshaller = context.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(schemaFile);
        unmarshaller.setSchema(schema);
    }


    @Test
    public void testSerialize() throws JAXBException {
        StringWriter vastStream = new StringWriter();
        marshaller.marshal(originalVast, vastStream);

        assertTrue(vastStream.toString().length() > 500);
    }


    @Test
    public void testDeserializationAndSchemaIsValid() throws JAXBException {
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(originalVast, stringWriter);

        Vast vast = (Vast) unmarshaller.unmarshal(new StringReader(stringWriter.toString()));

        assertEquals(vast.getAd().getId(), adId);
        assertEquals(vast.getAd().getInLine().getImpression(), originalVast.getAd().getInLine().getImpression());
        assertEquals(vast.getAd().getInLine().getCreatives().size(), originalVast.getAd().getInLine().getCreatives().size());
    }

    @Test
    public void testEntitiesHasNoArgsConstructor(){
        assertNotNull(new Vast());
        assertNotNull(new InLine());
        assertNotNull(new AdSystem());
        assertNotNull(new Ad());
        assertNotNull(new Creative());
        assertNotNull(new Linear());
        assertNotNull(new MediaFile());
        assertNotNull(new TrackingEvent());
        assertNotNull(new ClickThrough());
    }
}
