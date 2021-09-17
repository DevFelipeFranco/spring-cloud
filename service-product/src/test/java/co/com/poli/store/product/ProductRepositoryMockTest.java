package co.com.poli.store.product;

import co.com.poli.store.product.entities.Category;
import co.com.poli.store.product.entities.Product;
import co.com.poli.store.product.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void when_findByCategory_return_ListProduct(){
        Product product = Product.builder()
                .name("Juguete")
                .stock(5D)
                .price(10000D)
                .category(Category.builder().id(3L).build())
                .build();
        productRepository.save(product);
        List<Product> products = productRepository.findByCategory(product.getCategory());
        Assertions.assertThat(products.size()).isEqualTo(2);
    }

}
