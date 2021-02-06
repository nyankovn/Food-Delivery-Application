package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.menu.TypeProduct;
import guru.framework.springmvcrest.repository.MenuRepository;
import guru.framework.springmvcrest.repository.ProductRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public ProductServiceImpl(ProductRepository productRepository, RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.productRepository = productRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductsById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + "does not exist"));

        return product;
    }

    @Override
    public Product createProduct(Product product, Long menuId, String typeProduct) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu with id " + menuId + "does not exist"));

        product.setTypeProduct(TypeProduct.valueOf(typeProduct));
        product.setMenu(menu);

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + productId + "does not exist"));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setAmount(productDetails.getAmount());
        product.setImg_dir(productDetails.getImg_dir());
        product.setTypeProduct(productDetails.getTypeProduct());

        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public Map<String, Boolean> deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + "does not exist"));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
