package com.github.nossomercadolivre;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/product")
public class ProductResource {

    private final ProductRepository productRepository;

    public ProductResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping()
    public ResponseEntity<ProductDtoOut> newUser(@Valid @RequestBody final ProductDtoIn productDtoIn) {
        Product productSaved = productRepository.save(productDtoIn.toModel());
        return ok(new ProductDtoOut(productSaved));
    }
}
