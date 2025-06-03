package Erika.Mityukova.ProductsList.controller;

import Erika.Mityukova.ProductsList.model.Product;
import Erika.Mityukova.ProductsList.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class ProductControllerTest {
    @Mock
    public ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    /**
     * тест метода по созданию продукта
     */
    @Test
    public void testCreateProduct(){
        // подготовка данных
        Product product = new Product(1L, "Apple", "Fresh apple", 50);
        when(productService.addProduct(product)).thenReturn(product);
        // выполнение метода
        ResponseEntity<Product> responseEntity = productController.createProduct(product);
        // проверка результата
        assertNotNull(responseEntity);
        assertEquals(product, responseEntity.getBody());
        verify(productService).addProduct(product);
    }

    /**
     * тест метода получения списка всех продуктов
     */
    @Test
    public void testGetAllProducts(){
        //подготовка списка продуктов
        List<Product> productList = Arrays.asList(
                new Product(1L, "Apple", "apple fresh", 100),
                new Product(2L, "Orange", "orange fresh", 200)
        );
        when(productService.getAllProduct()).thenReturn(productList);
        // выполнение метода
        ResponseEntity<List<Product>> responseEntity = productController.getAllProduct();
        // проверка результата
        assertNotNull(responseEntity);
        assertEquals(productList, responseEntity.getBody());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void testSearchProducts(){
        //подготовка данных для поиска
        String search = "Apple";
        List<Product>products = Arrays.asList(
                new Product(1L, "Apple", "apple fresh", 200),
                new Product(2L, "Orange", "orange fresh", 200)
        );
        when(productService.searchProducts(search)).thenReturn(products);
        //выполнение поиска
        ResponseEntity<List<Product>> response = productController.searchProducts(search);
        //проверка результата
        assertNotNull(response);
        assertEquals(products, response.getBody());
        assertEquals(2,response.getBody().size());
        assertEquals("Apple", response.getBody().get(0).getName());
        verify(productService).searchProducts(search);
    }
    @Test
    void testUpdateProduct(){
        Long productId = 1L;
        Product product = new Product(productId, "Product 1", "Description", 150);
        when(productService.addProduct(product)).thenReturn(product);
        ResponseEntity<Product> response = productController.updateProduct(productId, product);

        assertNotNull(response);
        assertEquals(product, response.getBody());
        assertEquals(productId, product.getId());
        verify(productService).addProduct(product);
    }

    @Test
    void testDeleteProduct(){
        Long productId = 1L;
        doNothing().when(productService).deleteProduct(productId);
        ResponseEntity<Void> response = productController.deleteProduct(productId);
        assertNotNull(response);
        verify(productService).deleteProduct(productId);
    }

}

