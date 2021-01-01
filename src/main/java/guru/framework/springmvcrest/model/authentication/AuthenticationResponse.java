package guru.framework.springmvcrest.model.authentication;

import guru.framework.springmvcrest.model.users.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AuthenticationResponse implements Serializable {

    private final String accessToken;
    private long id;
    private String username;
    private String email;
    private transient List<Role> roles;


    public AuthenticationResponse(String accessToken,long id,  String username, String email, List<Role> roles) {
        this.id=id;
        this.accessToken = accessToken;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
