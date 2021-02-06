package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(RoleController.BASE_URL)
public class RoleController {

    public static final String BASE_URL = "/admin_ui";

    @Autowired
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        if (roleRepository.findByName("Admin") == null) {
            roleRepository.save(new Role("Admin"));
        }
        if (roleRepository.findByName("Customer") == null) {
            roleRepository.save(new Role("Customer"));
        }
        if (roleRepository.findByName("RestaurantOwner") == null) {
            roleRepository.save(new Role("RestaurantOwner"));
        }
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


}
