package guru.framework.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.users.Profile;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Name must not be empty")
    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "location")
    private String location;

    @NotEmpty(message = "Phone number must not be empty")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "rating")
    private double rating;

    @Column(name = "rating_votes")
    private int ratingVotes;

    @Column(name = "opening_hour")
    private long openingHour;

    @Column(name = "closing_hour")
    private long closingHour;

    @Column(name = "min_mins_to_prepare")
    private int minMinsToPrepare;

    @Column(name = "max_mins_to_prepare")
    private int maxMinsToPrepare;

    @Column(name = "img_dir")
    private String img_dir;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference(value = "restaurant-menu")
    private List<Menu> menus;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinTable(
            name = "restaurants_tags",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
//    @JsonManagedReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Product.class)
    private List<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JsonBackReference(value = "restaurant-profile")
    private Profile profile;

    public Restaurant() {

    }

    public Restaurant(String name, String location, String phoneNumber, double rating, int ratingVotes, long openingHour, long closingHour, int minMinsToPrepare, int maxMinsToPrepare) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.ratingVotes = ratingVotes;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.minMinsToPrepare = minMinsToPrepare;
        this.maxMinsToPrepare = maxMinsToPrepare;
        this.ratingVotes = 0;
        this.rating = 0;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        double totalSum = getRating();

        if (totalSum == 0) {
            totalSum += rating;
            this.rating = totalSum;
        } else {
            totalSum += rating;
            this.rating = totalSum / 2;
        }
    }

    public int getRatingVotes() {
        return ratingVotes;
    }

    public void setRatingVotes() {
        this.ratingVotes += 1;
    }

    public long getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(long openingHour) {
        this.openingHour = openingHour;
    }

    public long getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(long closingHour) {
        this.closingHour = closingHour;
    }

    public int getMinMinsToPrepare() {
        return minMinsToPrepare;
    }

    public void setMinMinsToPrepare(int minMinsToPrepare) {
        this.minMinsToPrepare = minMinsToPrepare;
    }

    public int getMaxMinsToPrepare() {
        return maxMinsToPrepare;
    }

    public void setMaxMinsToPrepare(int maxMinsToPrepare) {
        this.maxMinsToPrepare = maxMinsToPrepare;
    }

    public String getImg_dir() {
        return img_dir;
    }

    public void setImg_dir(String img_dir) {
        this.img_dir = img_dir;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
