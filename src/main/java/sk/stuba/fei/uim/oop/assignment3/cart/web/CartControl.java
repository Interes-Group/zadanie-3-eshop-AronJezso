package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.Logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartControl {


    private ICartService cartService;

    @GetMapping("/{id}")
    public List<ProductResponse> getById(@PathVariable("id") Long id) {
        return this.cartService.getById(id).stream().map(ProductResponse::new).collect(Collectors.toList());
    }




}
