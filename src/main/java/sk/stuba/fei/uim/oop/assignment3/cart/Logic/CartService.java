package sk.stuba.fei.uim.oop.assignment3.cart.Logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRep;
import sk.stuba.fei.uim.oop.assignment3.cart.web.ProductIdRequest;
import sk.stuba.fei.uim.oop.assignment3.product.Logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product.*;
import sk.stuba.fei.uim.oop.assignment3.product.exeption.*;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRep repository;

    @Autowired
    private IProductService productService;
    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }

    @Override
    public Cart getById(Long id) throws NotFoundException {
        Cart cart = this.repository.findCartById(id);
        if (cart == null) {
            throw new NotFoundException();
        }
        return cart;
    }

    @Override
    public void delete(Long id) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getById(id);
        this.repository.delete(cart);
    }
    @Override
    public Cart addToList(Long id, ProductIdRequest body) throws NotFoundException, IllegalOperationException {
        return null;
    }

    @Override
    public Cart removeFromList(Long id, ProductIdRequest body) throws NotFoundException, IllegalOperationException {
        return null;
    }
}
