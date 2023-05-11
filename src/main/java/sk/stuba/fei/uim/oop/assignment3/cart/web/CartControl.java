package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.Logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.exeption.*;


@RestController
@RequestMapping("/cart")
public class CartControl {


    private final ICartService cartService;

    public CartControl(ICartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping()
    public ResponseEntity<CartResponse> addCart() {
        return new ResponseEntity<>(new CartResponse(this.cartService.create()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CartResponse getList(@PathVariable("id") Long listId) throws NotFoundException {
        return new CartResponse(this.cartService.getCartById(listId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long listId) throws NotFoundException {
        this.cartService.delete(listId);
    }

    @PostMapping("/{id}/add")
    public CartResponse addToCart(@PathVariable("id") Long cartId, @RequestBody CartEntry cartEntry) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.cartService.addToCart(cartId, cartEntry));
    }

    @GetMapping("/{id}/pay")
    public String payForCart(@PathVariable("id") Long cartId) throws NotFoundException, IllegalOperationException {
        return "" + this.cartService.payForCart(cartId);
    }
}
