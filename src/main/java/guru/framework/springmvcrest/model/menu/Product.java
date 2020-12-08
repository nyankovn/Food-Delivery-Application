package guru.framework.springmvcrest.model.menu;

import com.fasterxml.jackson.annotation.*;
import guru.framework.springmvcrest.model.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.PERSIST)
    @JsonBackReference(value="product-menu")
    private Menu menu;


    @ManyToMany(mappedBy = "products")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Order> orders = new ArrayList<>();
//    private Set<Order> orders=new HashSet<>();

    public Product() {

    }
    public Product(long id, String name, double price, double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
