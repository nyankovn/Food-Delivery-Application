package guru.framework.springmvcrest.model.menu;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "meals")
public class Meal extends Product {
    @Column(name = "description")
    private String description;

    public Meal() {

    }

    public Meal(String name, double price, double amount, String description) {
        super(name, price, amount);
        this.description = description;
    }
}
