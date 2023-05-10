package sk.stuba.fei.uim.oop.assignment3.cart.Logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import sk.stuba.fei.uim.oop.assignment3.cart.web.CartEntry;
import sk.stuba.fei.uim.oop.assignment3.exeption.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFoundException;


public interface ICartService {

    Cart create();

    Cart getCartById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;



    double payForCart(Long id) throws NotFoundException, IllegalOperationException;


    Cart addToCart(Long id, CartEntry body) throws NotFoundException, IllegalOperationException;


}
