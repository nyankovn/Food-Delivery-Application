package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Order;
//import guru.framework.springmvcrest.model.users.RestaurantOwner;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drinks")
public class Drink extends Product {
    public Drink() {

    }

    public Drink(long id, String name, double price, double amount, long id1) {
        super(id, name, price, amount);
        this.id = id1;
    }
}
