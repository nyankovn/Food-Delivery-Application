package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class RestaurantServiceTest {

    private EntityManager entityManager;
    private RestaurantRepository restaurantRepository;

    @Test
    public void whenFindAll_thenReturnListRestaurant() {
        // given
        Employee alex = new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(alex.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());
    }
}