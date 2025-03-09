package lt.vilniustech.dpanasenko.first_spring.service;

import lt.vilniustech.dpanasenko.first_spring.db.CustomerRepository;
import lt.vilniustech.dpanasenko.first_spring.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Customer service.
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Instantiates a new Customer service.
     *
     * @param customerRepository the customer repository
     */
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Gets customers by filter.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @return the customers by filter
     */
    public List<Customer> getCustomersByFilter(String firstName, String lastName, String email) {
        if (firstName != null) {
            return customerRepository.findByFirstName(firstName);
        } else if (lastName != null) {
            return customerRepository.findByLastName(lastName);
        } else if (email != null) {
            return customerRepository.findByEmail(email);
        } else {
            return customerRepository.findAll();
        }
    }
}
