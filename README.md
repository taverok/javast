# About
Library for creating VAST compatible ads and serializing them to XML 

# Usage
### One simple ad
```
Creative creative = new Creative("prerollId", "00:00:15")
        .addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
        .addClickCallback("http://clickUrl")
        .addMedia("http://mediaUrl", 1280, 720);
        
Vast vast = new Vast("2.0");
vast.newAd()
        .newInline("http://impressionUrl", "Advertisement", "AdService")
        .addCreative(creative);
```

### Many ads and events
```
Creative creative = new Creative("prerollId", "00:00:15")
        .addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
        .addClickCallback("http://clickUrl")
        .addMedias(Arrays.asList("http://mediaUrl", "http://mediaUrl", "http://mediaUrl"), 1280, 720);
        
MediaFile m = new MediaFile("http://mediaUrl", 1280, 720);
m.setType("video/webm");
m.setScalable(false);

Creative anotherCreative = new Creative("prerollId", "00:00:15")
        .addTrackingCallback(START, "http://playUrl")
        .addTrackingCallback(FIRST_QUARTILE, "http://playUrl")
        .addTrackingCallback(PAUSE, "http://playUrl")
        .addMedia(m);
        
Vast vast = new Vast("2.0");
vast.newAd()
        .newInline("http://impressionUrl", "Advertisement", "AdService")
        .addCreatives(Arrays.asList(creative, anotherCreative));
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