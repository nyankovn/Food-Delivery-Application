package guru.framework.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import guru.framework.springmvcrest.model.menu.Menu;
//import guru.framework.springmvcrest.model.users.RestaurantOwner;
import guru.framework.springmvcrest.model.menu.Product;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {

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
    private int raitingVotes;

    @Column(name = "opening_hour")
    private long openingHour;
    @Column(name = "closing_hour")
    private long closingHour;

    @Column(name = "min_mins_to_prepare")
    private int minMinsToPrepare;
    @Column(name = "max_mins_to_prepare")
    private int maxMinsToPrepare;

//    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
//    private Menu menu;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Menu> menus;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    //one of the two sides of the relationship should not be serialized, in order to avoid the infite loop
    private List<Tag> tags;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
//    private RestaurantOwner restaurantOwner;

    public Restaurant() {

    }

    public Restaurant(String name, String location, String phoneNumber, double rating, int raitingVotes, long openingHour, long closingHour, int minMinsToPrepare, int maxMinsToPrepare, Menu menu) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.raitingVotes = raitingVotes;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.minMinsToPrepare = minMinsToPrepare;
        this.maxMinsToPrepare = maxMinsToPrepare;
    }





    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurant_id")
//    private List<Menu> menus=new ArrayList<>();
}
