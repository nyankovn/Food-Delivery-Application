package guru.framework.springmvcrest.model.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import guru.framework.springmvcrest.model.Restaurant;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "menus")
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "menu_title")
    private String title;


//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
//    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Restaurant restaurant;

    public Menu() {

    }

    public Menu(String title, List<Product> products, Restaurant restaurant) {
        this.title = title;
        this.products = products;
        this.restaurant = restaurant;
    }

    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "menu_id")
//    private List<Product> products=new ArrayList<>();
}
