package guru.framework.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.users.Profile;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "restaurants")
public class Restaurant implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "rating", nullable = true)
    private double rating;
    @Column(name = "rating_votes", nullable = true)
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

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference(value="restaurant-menu")
    private  List<Menu> menus;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinTable(
            name = "restaurants_tags",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private  List<Tag> tags=new ArrayList<>();


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference(value="restaurant-order")
    private  List<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JsonBackReference(value = "restaurant-profile")
    private  Profile profile;

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
    }
}
