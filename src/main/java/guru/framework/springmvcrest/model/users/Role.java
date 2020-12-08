package guru.framework.springmvcrest.model.users;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "roles")

public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "roles")
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityInfo( generator= ObjectIdGenerators.PropertyGenerator.class, property="id" )
    @JsonIgnore
    private List<Profile> profiles= new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
//    @JsonBackReference
////one of the two sides of the relationship should not be serialized, in order to avoid the infite loop
//    private Profile profile;

}
