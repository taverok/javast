package com.taverok.javast.service;


import com.taverok.javast.domain.Version;
import com.taverok.javast.domain.base.Vast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XmlServiceTest {
    VastService vastService;

    @BeforeEach
    public void init(){
        vastService = new VastService();
    }

    @Test
    public void getXml() {
        String vast = vastService.getXml(new Vast(Version.V2_0));

        assertEquals(vast, "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<VAST version=\"2.0\"/>\n");
    }
}
