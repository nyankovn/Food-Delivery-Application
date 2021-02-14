package guru.framework.springmvcrest.service;

import guru.framework.springmvcrest.security.model.AuthenticationRequest;
import guru.framework.springmvcrest.security.model.AuthenticationResponse;
import guru.framework.springmvcrest.model.users.Profile;

public interface AuthenticateService {

    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;

    Profile signupCustomer(Profile profile);
}
