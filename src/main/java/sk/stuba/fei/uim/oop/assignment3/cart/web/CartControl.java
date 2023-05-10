package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.Logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.exeption.*;


@RestController
@RequestMapping("/cart")
public class CartControl {

    @Autowired
    private ICartService cartService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addCart() {
        return new ResponseEntity<>(new CartResponse(this.cartService.create()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse getList(@PathVariable("id") Long listId) throws NotFoundException {
        return new CartResponse(this.cartService.getCartById(listId));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long listId) throws NotFoundException, IllegalOperationException {
        this.cartService.delete(listId);
    }

    @PostMapping(value = "/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse addToCart(@PathVariable("id") Long cartId, @RequestBody CartEntry cartEntry) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.cartService.addToCart(cartId, cartEntry));
    }

    @GetMapping(value = "/{id}/pay", produces = MediaType.TEXT_PLAIN_VALUE)
    public String payForCart(@PathVariable("id") Long cartId) throws NotFoundException, IllegalOperationException {
        return "" + this.cartService.payForCart(cartId);
    }
}
