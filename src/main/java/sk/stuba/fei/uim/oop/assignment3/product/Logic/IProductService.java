package sk.stuba.fei.uim.oop.assignment3.product.Logic;

import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductRequest;


import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product createProduct(ProductRequest body);

    List<Product> getById(Long id);
}
