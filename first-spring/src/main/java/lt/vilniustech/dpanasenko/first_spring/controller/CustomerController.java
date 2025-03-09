package lt.vilniustech.dpanasenko.first_spring.controller;

import lt.vilniustech.dpanasenko.first_spring.model.Customer;
import lt.vilniustech.dpanasenko.first_spring.service.CustomerService;
import lt.vilniustech.dpanasenko.first_spring.service.XMLTransformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;
    private final XMLTransformationService xmlTransformationService;

    /**
     * Instantiates a new Customer controller.
     *
     * @param customerService          the customer service
     * @param xmlTransformationService the xml transformation service
     */
    @Autowired
    public CustomerController(CustomerService customerService, XMLTransformationService xmlTransformationService) {
        this.customerService = customerService;
        this.xmlTransformationService = xmlTransformationService;
    }

    /**
     * Gets filtered customers.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @return the filtered customers
     */
    @GetMapping(produces = "application/json")
    public List<String> getFilteredCustomers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) {

        List<Customer> customers = customerService.getCustomersByFilter(firstName, lastName, email);

        return customers.stream()
                .map(xmlTransformationService::transformToXML)
                .collect(Collectors.toList());
    }
}
