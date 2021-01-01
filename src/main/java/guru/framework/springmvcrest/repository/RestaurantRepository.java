package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query(
            value = "SELECT SUM(p.price) AS Revenue\n" +
                    "FROM products p \n" +
                    "INNER JOIN order_product op \n" +
                    "ON op.product_id=p.id\n" +
                    "INNER JOIN orders o ON op.order_id = o.id \n" +
                    "INNER JOIN restaurants r\n" +
                    " ON o.restaurant_id=r.id WHERE r.id=1",
            nativeQuery = true)
    double getRevenue();

    @Query(
            value = "SELECT * FROM restaurants ORDER BY rating LIMIT 5",
            nativeQuery = true)

    List<Restaurant> getTopRatedRestaurants();
}
