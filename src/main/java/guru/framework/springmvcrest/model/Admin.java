package guru.framework.springmvcrest.model;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "admins")

//@AttributeOverride(name="id", column = @Column(name = "admin_id"))
public class Admin  extends User {

    public Admin() { }

    public Admin(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
    }
}
