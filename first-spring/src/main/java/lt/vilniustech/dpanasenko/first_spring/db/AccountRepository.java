package lt.vilniustech.dpanasenko.first_spring.db;

import lt.vilniustech.dpanasenko.first_spring.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * The interface Account repository.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * Find by account number list.
     *
     * @param accountNumber the account number
     * @return the list of accounts
     */
    List<Account> findByAccountNumber(BigInteger accountNumber);

    /**
     * Find by balance greater than list.
     *
     * @param balance the balance threshold
     * @return the list of accounts with balance greater than the given value
     */
    List<Account> findByBalanceGreaterThan(Float balance);

    /**
     * Find by balance less than list.
     *
     * @param balance the balance threshold
     * @return the list of accounts with balance less than the given value
     */
    List<Account> findByBalanceLessThan(Float balance);
}
