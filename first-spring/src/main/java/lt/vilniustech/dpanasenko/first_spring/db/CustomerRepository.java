package lt.vilniustech.dpanasenko.first_spring.db;

import lt.vilniustech.dpanasenko.first_spring.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    List<Customer> findByEmail(String email);
}
