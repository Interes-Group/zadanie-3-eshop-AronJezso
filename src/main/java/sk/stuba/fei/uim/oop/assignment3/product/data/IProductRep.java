package sk.stuba.fei.uim.oop.assignment3.product.data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRep extends JpaRepository<Product,  Long> {
    List<Product> findAll();
    List<Product> findAllById(Long id);

}
