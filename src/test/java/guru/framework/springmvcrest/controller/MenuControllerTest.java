package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.MenuRepository;
import guru.framework.springmvcrest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MenuControllerTest {

    @InjectMocks
    MenuController menuController;

    @Mock
    MenuRepository menuRepository;

    @Test
    public void testFindAll() {
        // given
        Restaurant restaurant=new Restaurant();
        Menu menu1 = new Menu("menu",null,restaurant);
        Menu menu2 = new Menu("menu2",null,restaurant);

        List<Menu> menus = new ArrayList<>();
        menus.add(menu1);
        menus.add(menu2);

        when(menuRepository.findAll()).thenReturn(menus);

        // when
        List<Menu> result = menuController.getAllMenus();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getTitle())
                .isEqualTo(menu1.getTitle());

        assertThat(result.get(1).getTitle())
                .isEqualTo(menu2.getTitle());
    }

    @Test
    public void testGetMenuByRestaurantId(){
        Restaurant restaurant=new Restaurant();
        List<Menu> menus=new ArrayList<>();
        restaurant.setMenus(menus);

        ResponseEntity<List<Menu>> expected=menuController.getMenuByRestaurantId(restaurant.getId());

        assertThat(expected.getBody()).isEqualTo(menus);
    }
}