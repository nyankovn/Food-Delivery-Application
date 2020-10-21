package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.users.RestaurantOwner;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "amount")
    private double amount;//ml and g

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
    private Menu menuDrinks;

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
    private Order orderDrinks;

    public Drink() {

    }

    public Drink(long id, String name, double price, double amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
