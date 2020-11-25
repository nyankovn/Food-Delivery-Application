//package guru.framework.springmvcrest.security;
//
//import guru.framework.springmvcrest.model.users.MyUserDetails;
//import guru.framework.springmvcrest.model.users.Profile;
//import guru.framework.springmvcrest.repository.ProfileRepository;
//import guru.framework.springmvcrest.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        Profile profile = profileRepository.getProfileByUsername(username);
//
//        if (profile == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
//
//        return new MyUserDetails(profile);
//    }
//
//}
