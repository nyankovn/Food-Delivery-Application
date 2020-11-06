package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.ProfileType;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/admin_ui";

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    @GetMapping("/admins")
//    public List<Admin> getAllAdmins() {
//        return adminRepository.findAll();
//    }

    @GetMapping("/admins")
    public List<User> getAllAdmins() {
        List<User> admins = new ArrayList<>();
        for (User admin : userRepository.findAll()) {
            for (Profile profile : admin.getProfiles()) {
                if (profile.getProfileType() == ProfileType.Admin) {
                    admins.add(admin);
                }
            }

        }
        return admins;
    }
}
