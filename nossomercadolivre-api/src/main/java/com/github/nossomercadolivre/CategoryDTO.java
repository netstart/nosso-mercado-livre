package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.nossomercadolivre.validation.UniqueNameCategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.util.Objects.isNull;

@JsonInclude(NON_NULL)
public class CategoryDTO {
    public Long id;

    @NotBlank
    @Size(max = 100)
    @UniqueNameCategory
    public String name;

    public CategoryDTO categoryMother;

    /**
     * For frameworks, don't use it
     */
    @Deprecated
    private CategoryDTO() {
    }

    public CategoryDTO(final Category category) {
        this.id = category.getId();
        this.name = category.getName();
        if (!isNull(this.categoryMother) && !isNull(this.categoryMother.id)) {
            this.categoryMother = new CategoryDTO(category.getCategoryMother());
        }
    }

    public static CategoryDTO toDTO(final Category category) {
        return new CategoryDTO(category);
    }

    public Category toModel() {
        return new Category(this.name);
    }

    public Long idCategoryMother() {
        if (!isNull(this.categoryMother) && !isNull(this.categoryMother.id)) {
            return categoryMother.id;
        }

        return 0L;
    }

}
