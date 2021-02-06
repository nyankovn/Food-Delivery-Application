package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.MenuRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.services.MenuService;
import guru.framework.springmvcrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(MenuController.BASE_URL)
public class MenuController {

    public static final String BASE_URL = "/admin_ui";

    @Autowired
    private MenuService menuService;


    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/menus/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @GetMapping("/restaurants/{restaurantId}/menus")
    public ResponseEntity<List<Menu>> getMenuByRestaurantId(@PathVariable Long restaurantId) {
        return new ResponseEntity<>(menuService.getMenuByRestaurantId(restaurantId), HttpStatus.OK);
    }

    @PostMapping("/restaurants/{restaurantId}/menus")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu, @PathVariable Long restaurantId) {
        return new ResponseEntity<>(menuService.createMenu(menu, restaurantId), HttpStatus.CREATED);
    }

    @PutMapping("/restaurants/{restaurantId}/menus/{menuId}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long menuId, @RequestBody Menu menuDetails) {
        return new ResponseEntity<>(menuService.updateMenu(menuId, menuDetails), HttpStatus.OK);
    }

    @DeleteMapping("/menus/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMenu(@PathVariable Long id) {
        return new ResponseEntity<>(menuService.deleteMenu(id), HttpStatus.OK);
    }
}
