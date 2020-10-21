package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Order;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "amount")
    private double amount;//ml and g
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
    private Menu menuMeals;

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
    private Order orderMeals;

    public Meal() {

    }

    public Meal(long id, String name, double price, double amount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }
}
