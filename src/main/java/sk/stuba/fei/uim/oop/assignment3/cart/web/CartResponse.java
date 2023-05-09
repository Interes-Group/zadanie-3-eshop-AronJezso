package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

@Getter
public class CartResponse {

    private Long id;
    private Product shoppingList;

    private boolean payed;

    public CartResponse(Cart cart) {
        this.payed = cart.isPayed();
    }
}
