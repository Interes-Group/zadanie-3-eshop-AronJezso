package sk.stuba.fei.uim.oop.assignment3.product.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateRequest {
    private String name;
    private String description;
    private String unit;
    private double price;
}
