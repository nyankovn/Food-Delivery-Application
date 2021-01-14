package guru.framework.springmvcrest.model.authentication;

import guru.framework.springmvcrest.model.users.Role;

import java.io.Serializable;
import java.util.List;

public class AuthenticationResponse implements Serializable {

    private final String accessToken;
    private long id;
    private String username;
    private String email;
    private  List<Role> roles;

    public AuthenticationResponse(String accessToken,long id,  String username, String email, List<Role> roles) {
        this.id=id;
        this.accessToken = accessToken;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
