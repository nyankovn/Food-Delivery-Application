package guru.framework.springmvcrest.model.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JsonBackReference(value = "user-profile")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User profileUser;

    @OneToMany(mappedBy = "profile")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference(value = "restaurant-profile")
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    @JsonBackReference(value = "order-profile")
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinTable(
            name = "profiles_roles",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    public Profile() {

    }

    public Profile(String email, String username, String password, User profileUser) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileUser = profileUser;
    }
}
