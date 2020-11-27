package guru.framework.springmvcrest.model.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    private boolean enabled;


//    @Enumerated(EnumType.STRING)
//    private ProfileType role;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JsonBackReference
//one of the two sides of the relationship should not be serialized, in order to avoid the infite loop
    private User user;

    @OneToMany(mappedBy = "profile")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "profile")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference
    private List<Order> orders;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(
            name = "profiles_roles",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();




//    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
//    @JsonManagedReference
//    private Set<Role> roles=new HashSet<>();



    public Profile() {

    }

    public Profile(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public  List<Role> getAllRoles(){
        return roles;
    }

//    @Column(name = "role")
//    private String role;
//
//
//    public Set<String> getRoles(){
//        Set<String> roles=new HashSet<>();
//        roles.add(role);
//        return roles;
//    }
}
