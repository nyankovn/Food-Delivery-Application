package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.Tag;
import guru.framework.springmvcrest.model.menu.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
