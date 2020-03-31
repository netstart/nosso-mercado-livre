package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.*;
import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class ProductDtoIn {

    @NotBlank
    public String name;

    @NotNull
    @DecimalMin(value = "1.0", inclusive = true)
    public BigDecimal value;

    @NotNull
    @Min(1)
    public Long quantityAvaiable;

    @NotBlank
    @Size(max = 1000)
    public String markdownDescription;

    @Deprecated
    private ProductDtoIn() {
    }

    public Product toModel() {
        return new Product(name, value, quantityAvaiable, markdownDescription);
    }
}
