package guru.framework.springmvcrest.model.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
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



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User getProfileUser() {
        return profileUser;
    }

    public void setProfileUser(User profileUser) {

        this.profileUser = profileUser;
        List<Profile> profiles=new ArrayList<>();
        profiles.add(this);
        profileUser.setProfiles(profiles);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
