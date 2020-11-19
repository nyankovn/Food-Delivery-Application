package guru.framework.springmvcrest.model.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import guru.framework.springmvcrest.model.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "name")
    protected String name;
    @Column(name = "price")
    protected double price;
    @Column(name = "amount")
    protected double amount;//ml and gr
//    @Column(name = "times_ordered")
//    protected int timesOrdered;

    //ml and gr
//    @Column(name = "menu_id",insertable = false, updatable = false)
//    protected double menuId;//ml and gr


//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    private Order order;

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Menu menu;

//    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
//    @JsonBackReference
//    private Order order;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();

    public Product() {

    }
    public Product(long id, String name, double price, double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
