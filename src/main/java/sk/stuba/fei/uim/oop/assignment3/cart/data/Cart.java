package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import javax.persistence.*;


@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;
    private boolean payed;

    public Cart(Product product, Long amount) {
        this.product = product;
        this.amount = amount;
    }


}
