package sk.stuba.fei.uim.oop.assignment3.cart.Logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;

public interface ICartService {
    List<Product> getById(Long id);

}
