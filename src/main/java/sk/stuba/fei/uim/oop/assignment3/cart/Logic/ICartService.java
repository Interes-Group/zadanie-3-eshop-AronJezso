package sk.stuba.fei.uim.oop.assignment3.cart.Logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.ProductIdRequest;
import sk.stuba.fei.uim.oop.assignment3.product.exeption.*;
import sk.stuba.fei.uim.oop.assignment3.product.exeption.NotFoundException;

import java.util.List;

public interface ICartService {

    Cart create();

    Cart getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException, IllegalOperationException;

    Cart addToList(Long id, ProductIdRequest body) throws NotFoundException, IllegalOperationException;

    Cart removeFromList(Long id, ProductIdRequest body) throws NotFoundException, IllegalOperationException;


}
