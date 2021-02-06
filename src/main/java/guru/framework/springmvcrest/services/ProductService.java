package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.menu.TypeProduct;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductsById(Long id);

    Product createProduct(Product product, Long menuId, String typeProduct);

    Product updateProduct(Long productId, Product productDetails);

    Map<String, Boolean> deleteProduct(Long id);
}
