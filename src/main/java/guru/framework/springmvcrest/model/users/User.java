//package guru.framework.springmvcrest.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//
//@Table(name = "users")
////@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
////@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public  class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    protected long id;
//    @Column(name = "first_name")
//    protected String firstName;
//    @Column(name = "last_name")
//    protected String lastName;
//    @Column(name = "phone_number")
//    protected String phoneNumber;
//    @Column(name = "address")
//    protected String address;
//    @Column(name = "profile_id")
//    protected String profileId;
//
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "profile_id", referencedColumnName = "id")
////    private Profile profile;
//
//    public User() {}
//
//    public User(long id, String firstName, String lastName, String phoneNumber, String address) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//    }
//}
