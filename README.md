# About
Library for creating VAST compatible ads and serializing them to XML 

# Usage
### One simple ad
```
        Version version = Version.V3_0;
        String prerollDuration = vastService.durationToString(15);

        Creative creative = Creative.newLinear("prerollId", prerollDuration);
        creative.getLinear().setSkipoffset("00:00:05", version);

        creative.addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
                .addTrackingCallback(SKIP, "http://playUrl")
                .addClickThrough("http://clickUrl")
                .addMedia("http://mediaUrl", 1280, 720);

        Vast vast = new Vast(version);
        vast.newAd("122222")
                .newInline("http://impressionUrl", "Advertisement", "AdService")
                //.addCustomCallback(new TrackingEvent(SKIP, "http://playUrl")) for version < 3.0
                .addCreative(creative);
```

### No ads
```
    vast.noAds();
```

### Serialize
```
    XmlService xmlService = new XmlService();
    String xml = xmlService.getXml(vast);
```

# Links
- https://raw.githubusercontent.com/InteractiveAdvertisingBureau/vast/master/vast_2.0.1.xsd
- https://www.iab.com/wp-content/uploads/2015/11/VAST-2_0-FINAL.pdf
- https://www.iab.com/wp-content/uploads/2015/06/VASTv3_0.pdf
- https://www.iab.com/insights/vast-2-0-xml-samples-for-testing/
