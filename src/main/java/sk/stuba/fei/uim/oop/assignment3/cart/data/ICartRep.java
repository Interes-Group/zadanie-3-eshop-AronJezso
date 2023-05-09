package sk.stuba.fei.uim.oop.assignment3.cart.data;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;

public interface ICartRep extends JpaRepository<Cart,Long> {
    List<Product> findCartById(Long id);
}
