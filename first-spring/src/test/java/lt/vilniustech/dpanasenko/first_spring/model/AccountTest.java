package lt.vilniustech.dpanasenko.first_spring.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import lt.vilniustech.dpanasenko.first_spring.db.AccountRepository;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountEntityTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testAccountPersistence() {
        Account account = new Account();
        account.setAccountNumber(BigInteger.valueOf(1234567890));
        account.setBalance(1000.50f);

        Account savedAccount = accountRepository.save(account);

        assertNotNull(savedAccount.getId());
        assertEquals(BigInteger.valueOf(1234567890), savedAccount.getAccountNumber());
        assertEquals(1000.50f, savedAccount.getBalance());
    }
}
