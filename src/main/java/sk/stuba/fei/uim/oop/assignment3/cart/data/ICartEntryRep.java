package sk.stuba.fei.uim.oop.assignment3.cart.data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartEntryRep extends JpaRepository<CartEntry,  Long> {
    List<CartEntry> findAll();



}
