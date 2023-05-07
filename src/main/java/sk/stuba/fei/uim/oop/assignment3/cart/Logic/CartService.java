package sk.stuba.fei.uim.oop.assignment3.cart.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartEntryRep;

import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    private ICartEntryRep repository;
    public List<CartEntry> getAll(){
        return this.repository.findAll();
    }
}
