package guru.framework.springmvcrest.model;

import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.users.RestaurantOwner;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "phone_number")
    private String phoneNum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    private RestaurantOwner restaurantOwner;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Menu menu;

    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurant_id")
//    private List<Menu> menus=new ArrayList<>();
    public Restaurant() {

    }

    public Restaurant(long id, String name, String location, String phoneNum, RestaurantOwner restaurantOwner, Menu menu) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phoneNum = phoneNum;
        this.restaurantOwner = restaurantOwner;
        this.menu = menu;
    }

    public boolean CreateMenu() {
        return true;
    }
}
