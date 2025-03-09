package lt.vilniustech.dpanasenko.first_spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CustomerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllCustomers() {
        ResponseEntity<List> response = restTemplate.getForEntity("/customers", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void getCustomersByFirstName() {
        ResponseEntity<List> response = restTemplate.getForEntity("/customers?firstName=New customer 1", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void getCustomersByLastName() {
        ResponseEntity<List> response = restTemplate.getForEntity("/customers?lastName=Customer 2", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void getCustomersByEmail() {
        ResponseEntity<List> response = restTemplate.getForEntity("/customers?email=a@gmail.com", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void getCustomersWithInvalidFilterReturnsEmpty() {
        ResponseEntity<List> response = restTemplate.getForEntity("/customers?firstName=NonExistent", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
    }
}
