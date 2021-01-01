package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {
    public static final String BASE_URL = "/admin_ui";

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{menuId}")
    public ResponseEntity<List<Product>> getProductsByMenuId(@PathVariable Long menuId) {
        List<Product> allProductsWithMenuId = new ArrayList<>();
        for (Product p : productRepository.findAll()) {
            if (p.getMenu().getId() == menuId) {
                allProductsWithMenuId.add(p);
            }
        }
        return ResponseEntity.ok(allProductsWithMenuId);
    }
}
