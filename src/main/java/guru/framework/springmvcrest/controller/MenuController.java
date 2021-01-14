package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.repository.MenuRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(MenuController.BASE_URL)
public class MenuController {

    public static final String BASE_URL = "/admin_ui";

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @GetMapping("/menus/{restId}")
    public ResponseEntity<List<Menu>> getMenuByRestaurantId(@PathVariable Long restId) {
        List<Menu> allMenusByRestaurantId = new ArrayList<>();
        for (Menu m : menuRepository.findAll()) {
            if (m.getRestaurant().getId() == restId) {
                allMenusByRestaurantId.add(m);
            }
        }
        return ResponseEntity.ok(allMenusByRestaurantId);
    }
}
