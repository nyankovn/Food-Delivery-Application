package guru.framework.springmvcrest.service.serviceImpl;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.repository.MenuRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    private String menuWithId = "Menu with id ";
    private String restaurantWithId = "Restaurant with id ";
    private String doesNotExist = " does not exists";


    public MenuServiceImpl(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(menuWithId + id + doesNotExist));
    }

    @Override
    public List<Menu> getMenuByRestaurantId(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(restaurantWithId + restaurantId + doesNotExist));

        return restaurant.getMenus();
    }

    @Override
    public Menu createMenu(Menu menu, Long restaurantId) {
        menu.setRestaurant(restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(restaurantWithId + restaurantId + doesNotExist)));
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Long menuId, Menu menuDetails) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException(menuWithId + menuId + doesNotExist));

        menu.setTitle(menuDetails.getTitle());

        return menuRepository.save(menu);
    }

    @Override
    public Map<String, Boolean> deleteMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(menuWithId + id + doesNotExist));

        menuRepository.delete(menu);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
