package guru.framework.springmvcrest.service.serviceImpl;

import guru.framework.springmvcrest.security.service.MyUserDetailsService;
import guru.framework.springmvcrest.security.model.AuthenticationRequest;
import guru.framework.springmvcrest.security.model.AuthenticationResponse;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RoleRepository;
import guru.framework.springmvcrest.security.JwtUtil;
import guru.framework.springmvcrest.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Profile signupCustomer(Profile p) {
        Profile profile = new Profile();

        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("Customer");
        roles.add(role);

        profile.setUsername(p.getUsername());
        profile.setPassword(passwordEncoder.encode(p.getPassword()));
        profile.setProfileUser(p.getProfileUser());
        profile.setEmail(p.getEmail());
        profile.setRoles(roles);
        profile.setEnabled(true);
        return profileRepository.save(profile);
    }
}
