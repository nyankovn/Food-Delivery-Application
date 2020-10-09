package guru.framework.springmvcrest.model;

import lombok.Data;

import javax.persistence.*;

@Data

@Table(name = "users")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "first_name")
    protected String firstName;
    @Column(name = "last_name")
    protected String lastName;
    @Column(name = "phone_number")
    protected String phoneNumber;
    @Column(name = "email")
    protected String email;
    @Column(name = "password")
    protected String password;

    public User() {}

    protected User(String firstName, String lastName, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
