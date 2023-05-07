package sk.stuba.fei.uim.oop.assignment3.product.Logic;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRep;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductRep repository;

    public ProductService(IProductRep repository) {
        this.repository = repository;

    }

    public List<Product> getAll(){
        return this.repository.findAll();
    }

    public Product createProduct(ProductRequest body){
        Product a = new Product();
        a.setName(body.getName());
        a.setDescription(body.getDescription());
        a.setAmount(body.getAmount());
        a.setUnit(body.getUnit());
        a.setPrice(body.getPrice());
        return this.repository.save(a);
    }

    @Override
    public List<Product> getById(Long id) {
        return this.repository.findAllById(id);
    }
}
