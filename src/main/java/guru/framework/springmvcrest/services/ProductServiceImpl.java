package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.menu.TypeProduct;
import guru.framework.springmvcrest.repository.MenuRepository;
import guru.framework.springmvcrest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MenuRepository menuRepository;

    private String productWithId = "Product with id ";
    private String doesNotExist = " does not exists";

    public ProductServiceImpl(ProductRepository productRepository, MenuRepository menuRepository) {
        this.productRepository = productRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductsById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(productWithId + id + doesNotExist));
    }

    @Override
    public Product createProduct(Product product, Long menuId, String typeProduct) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu with id " + menuId + doesNotExist));

        product.setTypeProduct(TypeProduct.valueOf(typeProduct));
        product.setMenu(menu);

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(productWithId + productId + doesNotExist));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setAmount(productDetails.getAmount());
        product.setImgDir(productDetails.getImgDir());
        product.setTypeProduct(productDetails.getTypeProduct());

        return productRepository.save(product);
    }

    @Override
    public Map<String, Boolean> deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(productWithId + id + doesNotExist));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
