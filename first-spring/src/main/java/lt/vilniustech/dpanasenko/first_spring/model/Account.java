package lt.vilniustech.dpanasenko.first_spring.model;

import java.math.BigInteger;
import jakarta.persistence.*;

/**
 * The type Account.
 */
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private BigInteger accountNumber;
    private Float balance;

    /**
     * Instantiates a new Account.
     */
    public Account() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets account number.
     *
     * @return the account number
     */
    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets account number.
     *
     * @param accountNumber the account number
     */
    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public Float getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
