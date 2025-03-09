package lt.vilniustech.dpanasenko.first_spring.model;

import jakarta.persistence.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Table(name="customer")
@XmlRootElement
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany
    @JoinTable(
            name="Customer_Account",
            joinColumns=@JoinColumn(name="customer_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )

    private List<Account> accounts;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElementWrapper(name="accounts")
    @XmlElement(name="account")
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
