package lt.vilniustech.dpanasenko.first_spring.service;
import lt.vilniustech.dpanasenko.first_spring.model.Customer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

/**
 * The type Xml transformation service.
 */
@Service
public class XMLTransformationService {

    private final FileStorageService fileStorageService;

    /**
     * Instantiates a new Xml transformation service.
     *
     * @param fileStorageService the file storage service
     */
    @Autowired
    public XMLTransformationService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    /**
     * Transform to xml string.
     *
     * @param customer the customer
     * @return the string
     */
    public String transformToXML(Customer customer) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(customer, outputStream);

            return fileStorageService.saveFile("customer_" + customer.getId() + ".xml", outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
