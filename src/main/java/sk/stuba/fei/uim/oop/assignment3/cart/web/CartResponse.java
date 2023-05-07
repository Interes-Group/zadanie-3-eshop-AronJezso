package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;

@Getter
public class CartResponse {
    private Long id;
    private String name;

    public CartResponse(CartEntry cart) {
        this.id = cart.getId();
        this.name = cart.getName();

    }
}
