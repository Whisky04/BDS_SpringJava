package lt.vilniustech.dpanasenko.first_spring.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import lt.vilniustech.dpanasenko.first_spring.db.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Customer entity test.
 */
@DataJpaTest
class CustomerEntityTest {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Test customer persistence.
     */
    @Test
    void testCustomerPersistence() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");

        Customer savedCustomer = customerRepository.save(customer);

        assertNotNull(savedCustomer.getId());
        assertEquals("John", savedCustomer.getFirstName());
        assertEquals("Doe", savedCustomer.getLastName());
        assertEquals("john.doe@example.com", savedCustomer.getEmail());
    }
}
