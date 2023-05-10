package sk.stuba.fei.uim.oop.assignment3.cart.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntryRep extends JpaRepository<CartEntry, Long> {

    CartEntry findCartEntryById(Long id);
}
