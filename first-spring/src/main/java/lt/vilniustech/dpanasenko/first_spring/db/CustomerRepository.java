package lt.vilniustech.dpanasenko.first_spring.db;

import lt.vilniustech.dpanasenko.first_spring.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Customer repository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Find by first name list.
     *
     * @param firstName the first name
     * @return the list
     */
    List<Customer> findByFirstName(String firstName);

    /**
     * Find by last name list.
     *
     * @param lastName the last name
     * @return the list
     */
    List<Customer> findByLastName(String lastName);

    /**
     * Find by email list.
     *
     * @param email the email
     * @return the list
     */
    List<Customer> findByEmail(String email);
}
