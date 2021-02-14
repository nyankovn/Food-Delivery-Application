package guru.framework.springmvcrest.security.service;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.security.model.MyUserDetails;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private  ProfileRepository profileRepository;

    public MyUserDetailsService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException {
        Profile profile = profileRepository.findByUsername(username);

        if (profile == null) {
            throw new ResourceNotFoundException("Could not find user");
        }
        return new MyUserDetails(profile);
    }
}
