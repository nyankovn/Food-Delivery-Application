package guru.framework.springmvcrest.model;

import guru.framework.springmvcrest.model.menu.Drink;
import guru.framework.springmvcrest.model.menu.Meal;
//import guru.framework.springmvcrest.model.users.Customer;
//import guru.framework.springmvcrest.model.users.RestaurantOwner;
import guru.framework.springmvcrest.model.menu.Product;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "location")
    private String location;
    @Column(name = "price")
    private double price;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
//    private Customer customer;

//    @OneToMany( mappedBy = "order", fetch = FetchType.EAGER)
//    @Fetch(value = FetchMode.SUBSELECT)
//    private List<Product> products;
}
