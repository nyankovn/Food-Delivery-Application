package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.UserRepository;
import guru.framework.springmvcrest.services.RestaurantService;
import guru.framework.springmvcrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/admin_ui";

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserService userService;

    public UserController(UserRepository userRepository,UserService userService) {
        this.userRepository = userRepository;
        this.userService=userService;
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }



//    @GetMapping("/admins")
//    public List<User> getAllAdmins() {
//        List<User> admins = new ArrayList<>();
//        for (User admin : userRepository.findAll()) {
//            for (Profile profile : admin.getProfiles()) {
//                if (profile.getRole() == ProfileType.Admin) {
//                    admins.add(admin);
//                }
//            }
//
//        }
//        return admins;
//    }
}
