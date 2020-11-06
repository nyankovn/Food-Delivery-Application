//package guru.framework.springmvcrest.model.users;
//
//import guru.framework.springmvcrest.model.Order;
//import guru.framework.springmvcrest.model.Restaurant;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "customers")
//
//public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;
//    @Column(name = "phone_number")
//    private String phoneNumber;
//    @Column(name = "address")
//    private String address;
//    @Column(name = "currentLocation")
//    private String currentLocation;
//
//    @Column(name = "email")
//    private String email;
//    @Column(name = "username")
//    private String username;
//    @Column(name = "password")
//    private String password;
//
//    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
//    private List<Order> orders;
//
//    public Customer() {
//    }
//
//    public Customer(long id, String firstName, String lastName, String phoneNumber, String address, String currentLocation, String email, String username, String password) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.currentLocation = currentLocation;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }
//}
