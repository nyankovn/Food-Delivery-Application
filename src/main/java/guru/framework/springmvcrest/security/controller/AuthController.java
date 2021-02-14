package guru.framework.springmvcrest.security.controller;

import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.security.model.AuthenticationRequest;
import guru.framework.springmvcrest.security.model.AuthenticationResponse;
import guru.framework.springmvcrest.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class AuthController {
    @CrossOrigin(origins = "http://localhost:3000")
    @RestController
    public static class AuthenticateController {

        @Autowired
        private AuthenticateService authenticateService;

        @PostMapping("/authenticate/signin")
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

            return new ResponseEntity<>(authenticateService.createAuthenticationToken(authenticationRequest), HttpStatus.CREATED);
        }

        @PostMapping("/authenticate/signup")
        public ResponseEntity<Profile> signupCustomer(@RequestBody Profile profile) {
            return new ResponseEntity<>(authenticateService.signupCustomer(profile), HttpStatus.CREATED);
        }
    }
}
