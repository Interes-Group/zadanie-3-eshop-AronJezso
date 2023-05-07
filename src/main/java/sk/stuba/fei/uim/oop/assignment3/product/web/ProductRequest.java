package sk.stuba.fei.uim.oop.assignment3.product.web;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Long price;
}