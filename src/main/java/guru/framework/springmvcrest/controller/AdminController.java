package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Admin;
import guru.framework.springmvcrest.repository.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(AdminController.BASE_URL)
public class AdminController {
    public static final String BASE_URL="foodDelivery/admins";

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {this.adminRepository = adminRepository;}

    @GetMapping
    public List<Admin> getAllAdmins(){return adminRepository.findAll();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@RequestBody Admin admin){return adminRepository.save(admin);}
}
