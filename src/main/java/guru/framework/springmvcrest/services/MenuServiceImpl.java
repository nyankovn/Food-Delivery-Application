package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.repository.MenuRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;


    public MenuServiceImpl(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenuById( Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu with id " + id + "does not exist"));

        return menu;
    }

    @Override
    public List<Menu> getMenuByRestaurantId( Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + restaurantId + "does not exist"));
        ;
        return restaurant.getMenus();
    }

    @Override
    public Menu createMenu( Menu menu,  Long restaurantId) {
        menu.setRestaurant(restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + restaurantId + "does not exist")));
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu( Long menuId,  Menu menuDetails) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu with id " + menuId + "does not exist"));

        menu.setTitle(menuDetails.getTitle());

        Menu updatedMenu = menuRepository.save(menu);
        return updatedMenu;
    }

    @Override
    public  Map<String, Boolean>  deleteMenu( Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu with id " + id + "does not exist"));

        menuRepository.delete(menu);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
