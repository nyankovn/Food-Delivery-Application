package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.authentication.AuthenticationRequest;
import guru.framework.springmvcrest.model.authentication.AuthenticationResponse;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RoleRepository;
import guru.framework.springmvcrest.security.JwtUtil;
import guru.framework.springmvcrest.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthenticateController {

    private final ProfileRepository profileRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    public AuthenticateController(ProfileRepository profileRepository, RoleRepository roleRepository) {
        this.profileRepository = profileRepository;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/authenticate/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        Profile temp = profileRepository.findByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, temp.getId(), temp.getUsername(), temp.getEmail(), temp.getRoles()));
    }

    @PostMapping("/authenticate/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Profile signupCustomer(@RequestBody Profile profile) {
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("Customer");
        roles.add(role);
        profile.setRoles(roles);
        profile.setEnabled(true);
        return profileRepository.save(profile);
    }
}
