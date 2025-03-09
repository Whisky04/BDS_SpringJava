package lt.vilniustech.dpanasenko.first_spring.service;

import lt.vilniustech.dpanasenko.first_spring.db.CustomerRepository;
import lt.vilniustech.dpanasenko.first_spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

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
