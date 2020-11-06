package guru.framework.springmvcrest.model.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private ProfileType profileType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JsonBackReference
//one of the two sides of the relationship should not be serialized, in order to avoid the infite loop
    private User user;

    public Profile() {

    }

    public Profile(long id, String email, String username, String password, ProfileType profileType) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileType = profileType;
    }
}
