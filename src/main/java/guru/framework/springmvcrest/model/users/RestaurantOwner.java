package guru.framework.springmvcrest.model.users;

import guru.framework.springmvcrest.model.Restaurant;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "restaurant_owners")
//
//public class RestaurantOwner{
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
//    @Column(name = "number_restaurants")
//    private int nrRestaurants;
//
//    @Column(name = "email")
//    private String email;
//    @Column(name = "username")
//    private String username;
//    @Column(name = "password")
//    private String password;
//
//    @OneToMany(mappedBy = "restaurantOwner", fetch = FetchType.EAGER)
//    private List<Restaurant> restaurants;
//
//    public RestaurantOwner() {
//    }
//
//    public RestaurantOwner(long id, String firstName, String lastName, String phoneNumber, String address, int nrRestaurants, String email, String username, String password) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.nrRestaurants = nrRestaurants;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.restaurants = new ArrayList<>();
//    }
//}
