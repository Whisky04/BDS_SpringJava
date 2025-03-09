package lt.vilniustech.dpanasenko.first_spring.service;

import lt.vilniustech.dpanasenko.first_spring.model.Customer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

@Service
public class XMLTransformationService {

    public void transformToXML (Customer customer) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(customer, System.out);

        } catch (JAXBException e){
            System.out.println(e.getMessage());
        }
    }
}
