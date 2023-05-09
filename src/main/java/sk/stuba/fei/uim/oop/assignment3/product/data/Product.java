package sk.stuba.fei.uim.oop.assignment3.product.data;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Long amount;
    private String unit;
    private double price;


    public Product(String name, String description, Long amount, String unit, double price) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.unit = unit;
        this.price = price;
    }
}
