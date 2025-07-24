package softuni.exam.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;

public class XmlParserImpl implements XmlParser {
    @Override
    public <T> T fromXml(String xml, Class<T> tClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try (StringReader reader = new StringReader(xml)) {
            return (T) unmarshaller.unmarshal(reader);
        }
    }
}