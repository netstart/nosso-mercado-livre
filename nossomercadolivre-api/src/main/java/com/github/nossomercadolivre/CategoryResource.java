package com.github.nossomercadolivre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.github.nossomercadolivre.CategoryDTO.toDTO;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private final CategoryRepository categoryRepository;

    public CategoryResource(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ApiOperation(value = "Cria categoria nova")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "", response = String.class)
    })
    @PostMapping()
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody final CategoryDTO categoryDTO) {
        Category categorySaved = categoryRepository.save(categoryDTO.toModel(categoryRepository::findById));
        return ok(toDTO(categorySaved));
    }

}
