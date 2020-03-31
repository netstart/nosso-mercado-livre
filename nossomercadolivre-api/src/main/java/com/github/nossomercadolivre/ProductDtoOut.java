package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class ProductDtoOut {
    private Long id;

    private String name;

    private BigDecimal value;

    private Long quantityAvaiable;

    public ProductDtoOut(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.value = product.getValue();
        this.quantityAvaiable = product.getQuantityAvaiable();
    }
}
