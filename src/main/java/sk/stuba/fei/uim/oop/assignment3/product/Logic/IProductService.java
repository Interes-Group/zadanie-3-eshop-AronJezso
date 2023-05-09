package sk.stuba.fei.uim.oop.assignment3.product.Logic;
import sk.stuba.fei.uim.oop.assignment3.product.exeption.*;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductUpdateRequest;


import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product createProduct(ProductRequest body) throws NotFoundException;

    Product getById(Long id) throws NotFoundException;

    Product update(Long id, ProductUpdateRequest request) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Long getAmount(Long id) throws NotFoundException;

    Long addAmount(Long id, Long increment) throws NotFoundException;

}
