package sk.stuba.fei.uim.oop.assignment3.cart.Logic;


import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRep;
import sk.stuba.fei.uim.oop.assignment3.product.Logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;


public class CartService implements ICartService{

    private ICartRep repository;


    public CartService(ICartRep repository,IProductService productService) {
        this.repository = repository;

    }


    @Override
    public List<Product> getById(Long id) {
        return this.repository.findCartById(id);
    }


}
