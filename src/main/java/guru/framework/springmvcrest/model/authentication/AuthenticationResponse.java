package guru.framework.springmvcrest.model.authentication;

import guru.framework.springmvcrest.model.users.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class AuthenticationResponse implements Serializable {

    private final String accessToken;
    private String username;
    private String email;
    private List<Role> roles;


    public AuthenticationResponse(String accessToken,  String username, String email, List<Role> roles) {
        this.accessToken = accessToken;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
