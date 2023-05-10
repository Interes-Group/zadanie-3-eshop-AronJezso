package sk.stuba.fei.uim.oop.assignment3.cart.Logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;
import sk.stuba.fei.uim.oop.assignment3.exeption.*;

public interface ICartEntryService {

    CartEntry create();

    CartEntry getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    CartEntry save(CartEntry cartEntry);
}
