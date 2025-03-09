package lt.vilniustech.dpanasenko.first_spring.controller;

import lt.vilniustech.dpanasenko.first_spring.db.CustomerRepository;
import lt.vilniustech.dpanasenko.first_spring.model.Customer;
import lt.vilniustech.dpanasenko.first_spring.service.CustomerService;
import lt.vilniustech.dpanasenko.first_spring.service.XMLTransformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;
    private final XMLTransformationService xmlTransformationService;

    @Autowired
    public CustomerController(CustomerService customerService, XMLTransformationService xmlTransformationService) {
        this.customerService = customerService;
        this.xmlTransformationService = xmlTransformationService;
    }

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
