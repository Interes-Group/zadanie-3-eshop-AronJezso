package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.Logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.product.exeption.*;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

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
    public CartResponse getList(@PathVariable("id") long listId) throws NotFoundException {
        return new CartResponse(this.cartService.getById(listId));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long listId) throws NotFoundException, IllegalOperationException  {
        this.cartService.delete(listId);
    }
}
