package com.taverok.javast.service;


import com.taverok.javast.domain.Version;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XmlServiceTest {
    XmlService xmlService;

    @BeforeEach
    public void init(){
        xmlService = new XmlService();
    }

    @Test
    public void getXml() {
        String vast = xmlService.getXml(VastFactory.getInstance(Version.V2_0));

        assertEquals(vast, "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<VAST version=\"2.0\"/>\n");
    }
}
