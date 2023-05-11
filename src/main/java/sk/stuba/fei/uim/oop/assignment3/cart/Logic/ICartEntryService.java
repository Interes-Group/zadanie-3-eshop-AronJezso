package sk.stuba.fei.uim.oop.assignment3.cart.Logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;


public interface ICartEntryService {

    CartEntry create();


    CartEntry save(CartEntry cartEntry);
}
