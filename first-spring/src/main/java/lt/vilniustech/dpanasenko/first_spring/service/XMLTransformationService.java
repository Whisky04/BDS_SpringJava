package lt.vilniustech.dpanasenko.first_spring.service;

import lt.vilniustech.dpanasenko.first_spring.model.Customer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The type Xml transformation service.
 */
@Service
public class XMLTransformationService {

    private static final String XML_DIRECTORY = "xml_output/";

    /**
     * Transform to xml string.
     *
     * @param customer the customer
     * @return the string
     */
    public String transformToXML(Customer customer) {
        try {
            File directory = new File(XML_DIRECTORY);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String fileName = XML_DIRECTORY + "customer_" + customer.getId() + ".xml";
            File file = new File(fileName);

            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(customer, new FileOutputStream(file));

            return file.getAbsolutePath();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
