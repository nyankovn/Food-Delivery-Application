package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.menu.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<Menu> getAllMenus();

    Menu getMenuById(Long id);

    List<Menu> getMenuByRestaurantId(Long restaurantId);

    Menu createMenu(Menu menu, Long restaurantId);

    Menu updateMenu(Long menuId, Menu menuDetails);

    Map<String, Boolean> deleteMenu(Long id);
}
