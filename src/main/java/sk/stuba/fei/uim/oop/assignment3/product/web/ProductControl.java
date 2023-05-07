package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.product.Logic.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductControl {

    @Autowired
    private IProductService productService;
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest body) {
        return  new ResponseEntity<>(new ProductResponse(this.productService.createProduct(body)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public List<ProductResponse> getById(@PathVariable("id") Long id) {
        return this.productService.getById(id).stream().map(ProductResponse::new).collect(Collectors.toList());
    }

}
