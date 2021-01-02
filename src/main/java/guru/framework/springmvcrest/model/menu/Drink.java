package guru.framework.springmvcrest.model.menu;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "drinks")
public class Drink extends Product {
    public Drink() {

    }

    public Drink(String name, double price, double amount, long id1) {
        super(name, price, amount);
        this.id = id1;
    }
}
