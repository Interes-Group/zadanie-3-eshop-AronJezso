package sk.stuba.fei.uim.oop.assignment3.cart.Logic;



import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartEntry;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRep;
import sk.stuba.fei.uim.oop.assignment3.exeption.*;
import sk.stuba.fei.uim.oop.assignment3.product.Logic.IProductService;

import java.util.List;

@Service
public class CartService implements ICartService{

    private final ICartRep repository;
    private final IProductService productService;
    private final ICartEntryService cartEntryService;
    public CartService(ICartRep repository,IProductService productService,ICartEntryService cartEntryService) {
        this.repository = repository;
        this.productService = productService;
        this.cartEntryService = cartEntryService;
    }


    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }

    @Override
    public Cart getCartById(Long id) throws NotFoundException {
        Cart cart = this.repository.findCartById(id);
        if (cart == null) {
            throw new NotFoundException();
        }
        return cart;
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        this.repository.delete(this.getCartById(id));
    }


    @Override
    public Cart addToCart(Long id, CartEntry body) throws NotFoundException, IllegalOperationException {
       Cart cart = this.getUnpaid(id);
        this.productService.removeAmount(body.getProductId(), body.getAmount());
        var existingEntry = this.findCartEntryWithProduct(cart.getShoppingList(), body.getProductId());
        if (existingEntry == null) {
            sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry cartEntry = cartEntryService.create();
            cartEntry.setAmount(body.getAmount());
            cartEntry.setProduct(productService.getById(body.getProductId()));
            cart.getShoppingList().add(cartEntryService.save(cartEntry));
        } else {
            existingEntry.setAmount(existingEntry.getAmount() + body.getAmount());
            cartEntryService.save(existingEntry);
        }
        return this.repository.save(cart);
    }

    @Override
    public double payForCart(Long id) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getUnpaid(id);
        double sum = cart.getShoppingList().stream().mapToDouble(item -> item.getAmount() * item.getProduct().getPrice()).sum();
        cart.setPayed(true);
        this.repository.save(cart);
        return sum;
    }

    private Cart getUnpaid(Long id) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getCartById(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }
        return cart;
    }
    private sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry findCartEntryWithProduct(List<sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry> entries, long productId) {
        for (var entry : entries) {
            if (entry.getProduct().getId().equals(productId)) {
                return entry;
            }
        }
        return null;
    }
}
