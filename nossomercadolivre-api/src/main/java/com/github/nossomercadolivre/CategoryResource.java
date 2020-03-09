package com.github.nossomercadolivre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "Cria categoria nova")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "", response = String.class)
    })
    @PostMapping()
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        try {
            return ok(categoryService.save(categoryDTO));
        } catch (Exception e) {
            log.error("Error on crate new category", e);
            return new ResponseEntity(e, BAD_REQUEST);
        }

    }

}


