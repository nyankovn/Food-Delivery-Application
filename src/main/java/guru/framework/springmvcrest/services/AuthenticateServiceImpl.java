package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.authentication.AuthenticationRequest;
import guru.framework.springmvcrest.model.authentication.AuthenticationResponse;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RoleRepository;
import guru.framework.springmvcrest.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    private final ProfileRepository profileRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    public AuthenticateServiceImpl(ProfileRepository profileRepository, RoleRepository roleRepository) {
        this.profileRepository = profileRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public AuthenticationResponse createAuthenticationToken( AuthenticationRequest authenticationRequest) throws Exception {
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

        return new AuthenticationResponse(jwt, temp.getId(), temp.getUsername(), temp.getEmail(), temp.getRoles());
    }

    @Override
    public Profile signupCustomer(Profile profile){
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("Customer");
        roles.add(role);
        profile.setRoles(roles);
        profile.setEnabled(true);
        return profileRepository.save(profile);
    }
}
