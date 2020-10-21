package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Restaurant;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "menu_title")
    private String title;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menuMeals", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Meal> meals;

    @OneToMany(mappedBy = "menuDrinks", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Drink> drinks;

    public Menu() {

    }

    public Menu(long id, String title, Restaurant restaurant) {
        this.id = id;
        this.title = title;
        this.restaurant = restaurant;
        this.meals = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "menu_id")
//    private List<Product> products=new ArrayList<>();
}
