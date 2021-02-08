package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.authentication.AuthenticationRequest;
import guru.framework.springmvcrest.model.authentication.AuthenticationResponse;
import guru.framework.springmvcrest.model.users.Profile;

public interface AuthenticateService {

    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;

    Profile signupCustomer(Profile profile);
}
