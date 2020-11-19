package guru.framework.springmvcrest.model.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationRequest implements Serializable {
    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "password")
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
