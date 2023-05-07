package sk.stuba.fei.uim.oop.assignment3.cart.Logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;

import java.util.List;

public interface ICartService {
    List<CartEntry> getAll();
}
