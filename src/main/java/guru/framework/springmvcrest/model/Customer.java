package guru.framework.springmvcrest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customers")

public class Customer extends User{
    @Column(name = "address")
    private String address;

        public Customer() { }

    public Customer(String firstName, String lastName, String phoneNumber, String email, String password, String address) {
        super(firstName, lastName, phoneNumber, email, password);
        this.address = address;
    }
}
