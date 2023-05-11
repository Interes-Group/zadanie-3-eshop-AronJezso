package sk.stuba.fei.uim.oop.assignment3.cart.Logic;


import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntryRep;


@Service
public class CartEntryService implements ICartEntryService {


    CartEntryRep repository;

    public CartEntryService(CartEntryRep repository) {
        this.repository = repository;
    }

    @Override
    public CartEntry create() {
        return this.repository.save(new CartEntry());
    }

    @Override
    public CartEntry save(CartEntry cartEntry) {
        return this.repository.save(cartEntry);
    }
}
