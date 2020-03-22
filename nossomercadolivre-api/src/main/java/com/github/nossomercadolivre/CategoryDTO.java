package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.nossomercadolivre.validation.UniqueNameCategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.util.Optional.ofNullable;

@JsonInclude(NON_NULL)
public class CategoryDTO {
    public Long id;

    @NotBlank
    @Size(max = 100)
    @UniqueNameCategory
    public String name;

    private CategoryDTO categoryMother;

    /**
     * For frameworks, don't use it
     */
    @Deprecated
    private CategoryDTO() {
    }

    public CategoryDTO(final Category category) {
        this.id = category.getId();
        this.name = category.getName();

        category.getCategoryMother()
                .ifPresent(mother -> this.categoryMother = new CategoryDTO(mother));
    }


    public static CategoryDTO toDTO(final Category category) {
        return new CategoryDTO(category);
    }

    public Optional<CategoryDTO> getCategoryMother() {
        return ofNullable(categoryMother);
    }

    public Category save(final CategoryRepository categoryRepository) {
        Category category = new Category(name);
        category.setId(id);

        getCategoryMother().ifPresent(mother ->
                categoryRepository.findById(mother.id).ifPresent(category::setCategoryMother));

        return categoryRepository.save(category);
    }
}
