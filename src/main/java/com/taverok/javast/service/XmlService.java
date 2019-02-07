package com.taverok.javast.service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.Writer;

public class XmlService {
    public <T> String getXml(T object){
        Writer writer = new StringWriter();

        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, writer);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return writer.toString();
    }
}
