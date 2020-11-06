package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Order;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meals")
public class Meal extends Product {
    @Column(name = "description")
    private String description;

    public Meal() {

    }

    public Meal(long id, String name, double price, double amount, String description) {
        super(id, name, price, amount);
        this.description = description;
    }
}
