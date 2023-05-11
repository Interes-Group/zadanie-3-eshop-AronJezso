package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exeption.*;
import sk.stuba.fei.uim.oop.assignment3.product.Logic.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductControl {


    private final IProductService productService;

    public ProductControl(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest body) throws NotFoundException {
        return  new ResponseEntity<>(new ProductResponse(this.productService.createProduct(body)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable("id") Long id) throws NotFoundException{
        return new ProductResponse(this.productService.getById(id));
    }
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable("id") Long id, @RequestBody ProductUpdateRequest body) throws NotFoundException {
        return new ProductResponse(this.productService.update(id, body));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws NotFoundException {
        this.productService.delete(id);
    }

    @GetMapping("/{id}/amount")
    public Amount getAmount(@PathVariable("id") Long id) throws NotFoundException {
        return new Amount(this.productService.getAmount(id));
    }

    @PostMapping("/{id}/amount")
    public Amount addAmount(@PathVariable("id") Long id, @RequestBody Amount body) throws NotFoundException {
        return new Amount(this.productService.addAmount(id, body.getAmount()));
    }
}

