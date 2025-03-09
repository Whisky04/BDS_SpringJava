package lt.vilniustech.dpanasenko.first_spring.db;

import lt.vilniustech.dpanasenko.first_spring.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Customer repository test.
 */
@DataJpaTest
@Transactional
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer1, customer2, customer3;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();

        customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("john.doe@example.com");

        customer2 = new Customer();
        customer2.setFirstName("Jane");
        customer2.setLastName("Doe");
        customer2.setEmail("jane.doe@example.com");

        customer3 = new Customer();
        customer3.setFirstName("John");
        customer3.setLastName("Smith");
        customer3.setEmail("john.smith@example.com");

        // Save without setting ID, let Hibernate generate it
        customer1 = customerRepository.save(customer1);
        customer2 = customerRepository.save(customer2);
        customer3 = customerRepository.save(customer3);
    }

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    /**
     * Find by first name should return correct customers.
     */
    @Test
    void findByFirstName_ShouldReturnCorrectCustomers() {
        List<Customer> result = customerRepository.findByFirstName("John");
        assertEquals(2, result.size());
        assertTrue(result.contains(customer1));
        assertTrue(result.contains(customer3));
    }

    /**
     * Find by last name should return correct customers.
     */
    @Test
    void findByLastName_ShouldReturnCorrectCustomers() {
        List<Customer> result = customerRepository.findByLastName("Doe");
        assertEquals(2, result.size());
        assertTrue(result.contains(customer1));
        assertTrue(result.contains(customer2));
    }

    /**
     * Find by email should return correct customer.
     */
    @Test
    void findByEmail_ShouldReturnCorrectCustomer() {
        List<Customer> result = customerRepository.findByEmail("jane.doe@example.com");
        assertEquals(1, result.size());
        assertEquals(customer2.getEmail(), result.get(0).getEmail());
    }

    /**
     * Find by first name should return empty list when no match.
     */
    @Test
    void findByFirstName_ShouldReturnEmptyList_WhenNoMatch() {
        List<Customer> result = customerRepository.findByFirstName("Nonexistent");
        assertTrue(result.isEmpty());
    }
}
