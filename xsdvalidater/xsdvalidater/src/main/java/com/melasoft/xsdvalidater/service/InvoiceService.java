package com.melasoft.xsdvalidater.service;


import com.melasoft.xsdvalidater.generated.Faktura;
import com.melasoft.xsdvalidater.model.InvoiceEntity;
import com.melasoft.xsdvalidater.repository.InvoiceRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceEntity processAndSaveInvoice(String base64Xml) throws Exception {
        // 1. Base64 Decode
        String xmlContent = decodeBase64(base64Xml);

        // 2. XML Validation (XSD)
        validateXml(xmlContent);

        // 3. JAXB Unmarshal (Converting XML to Java object)
        Faktura faktura = unmarshalXml(xmlContent);

        // 4. Data Extraction (Extracting necessary data)
        //Faktura → Podmiot1 →DaneIdentyfikacyjne → NIP
        String nip = faktura.getPodmiot1().getDaneIdentyfikacyjne().getNIP();
        //Faktura → Fa → P1
        String p1 = faktura.getFa().getP1().toString();
        //Faktura → Fa → P2
        String p2 = faktura.getFa().getP2();

        // 5.Create invoiceEntity
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setNip(nip);
        invoiceEntity.setP1(p1);
        invoiceEntity.setP2(p2);

        //6.Save entity to table
        return invoiceRepository.save(invoiceEntity);
    }

    private String decodeBase64(String base64Xml) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Xml);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    private void validateXml(String xmlContent) throws SAXException, IOException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(getClass().getClassLoader().getResource("xsd/schema.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xmlContent)));
        } catch (SAXException e) {
            //When an error is received, the GlobalExceptionHandler class is accessed.
            throw new SAXException("XML validation failed: " + e.getMessage(), e);
        }
    }

    private Faktura unmarshalXml(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Faktura.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Faktura) unmarshaller.unmarshal(new StringReader(xmlContent));
    }
}
