//package guru.framework.springmvcrest.model.users;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name = "profiles")
//public class Profile {
//    @Id
//    @Column(name = "id")
//    private long id;
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Admin admin ;
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private RestaurantOwner restaurantOwner ;
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Customer customer ;
////    @OneToOne(mappedBy = "profiles")
////    private RestaurantOwner restaurantOwner;
////    @OneToOne(mappedBy = "profiles")
////    private Customer customer;
//
//    @Column(name = "email")
//    private String email;
//    @Column(name = "username")
//    private String username;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "profile_type")
//    private ProfileType profileType;
//
//}
