package Erika.Mityukova.ProductsList.service;

import Erika.Mityukova.ProductsList.model.Product;
import Erika.Mityukova.ProductsList.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * метод сохранения продукта
     * @param product
     * @return
     */
    public Product addProduct(Product product){
        return repository.save(product);
    }

    /**
     * метод просмотра списка всех продуктов
     * @return
     */
    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    /**
     * метод удаления продукта
     * @param id
     */
    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

    /**
     * метод поиска продукта по названию
     * @param name
     * @return
     */
    public List<Product> searchProducts(String name){
        return repository.findByName(name);
    }


}

