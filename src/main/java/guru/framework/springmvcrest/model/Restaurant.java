package guru.framework.springmvcrest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "restaurants")
//@AttributeOverride(name="id", column = @Column(name = "restaurant_id"))
public class Restaurant extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "restaurant_name")
    private String restaurantName;
    @Column(name = "address")
    private String address;
    
    public Restaurant(){}

    public Restaurant(String firstName, String lastName, String phoneNumber, String email, String password, String restaurantName, String address) {
        super(firstName, lastName, phoneNumber, email, password);
        this.restaurantName = restaurantName;
        this.address = address;
    }
}
