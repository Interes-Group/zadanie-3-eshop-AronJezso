package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.cart.Logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class CartControl {

    @Autowired
    private ICartService cartService;
    @GetMapping
    public List<CartResponse> getAllPCartEntries() {
        return this.cartService.getAll().stream().map(CartResponse::new).collect(Collectors.toList());
    }
}
