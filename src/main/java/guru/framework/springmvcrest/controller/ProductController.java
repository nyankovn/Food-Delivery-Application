package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable Long id) {
        return productService.getProductsById(id);
    }

    @PostMapping("/menus/{menuId}/{typeProduct}")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable Long menuId, @PathVariable String typeProduct) {
        return new ResponseEntity<>(productService.createProduct(product, menuId,typeProduct), HttpStatus.CREATED);
    }

    @PutMapping("/menus/{menuId}/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return new ResponseEntity<>(productService.updateProduct(id, productDetails), HttpStatus.OK);
    }

    @DeleteMapping("/menus/{menuId}/products/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProcuct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
