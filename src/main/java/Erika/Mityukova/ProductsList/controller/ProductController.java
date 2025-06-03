package Erika.Mityukova.ProductsList.controller;

import Erika.Mityukova.ProductsList.model.Product;
import Erika.Mityukova.ProductsList.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")

public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * метод добавления нового продукта
     * @param product
     * @return
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = service.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    /**
     * метод просмотра всех продуктов
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(service.getAllProduct());
    }

    /**
     * метод поиска продукта по названию
     * @param name
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String name){
        List<Product> searchProducts = service.searchProducts(name);
        return ResponseEntity.ok(searchProducts);

    }

    /**
     * метод изменения продукта
     * @param id
     * @param product
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product>updateProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        Product updateProduct = service.addProduct(product);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }
}

