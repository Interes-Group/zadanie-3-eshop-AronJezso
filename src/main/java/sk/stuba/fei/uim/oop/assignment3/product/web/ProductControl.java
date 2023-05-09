package sk.stuba.fei.uim.oop.assignment3.product.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.product.exeption.*;
import sk.stuba.fei.uim.oop.assignment3.product.Logic.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductControl {

    @Autowired
    private IProductService productService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest body) throws NotFoundException {
        return  new ResponseEntity<>(new ProductResponse(this.productService.createProduct(body)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getById(@PathVariable("id") Long id) throws NotFoundException{
        return new ProductResponse(this.productService.getById(id));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse update(@PathVariable("id") Long id, @RequestBody ProductUpdateRequest body) throws NotFoundException {
        return new ProductResponse(this.productService.update(id, body));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws NotFoundException {
        this.productService.delete(id);
    }

    @GetMapping(value = "/{id}/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public Amount getAmount(@PathVariable("id") Long id) throws NotFoundException {
        return new Amount(this.productService.getAmount(id));
    }

    @PostMapping(value = "/{id}/amount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Amount addAmount(@PathVariable("id") Long id, @RequestBody Amount body) throws NotFoundException {
        return new Amount(this.productService.addAmount(id, body.getAmount()));
    }
}

