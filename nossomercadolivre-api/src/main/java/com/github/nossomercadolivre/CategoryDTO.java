package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@JsonInclude(NON_NULL)
public class CategoryDTO {
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    private CategoryDTO categoryMother;

    /**
     * For frameworks, don't use it
     */
    @Deprecated
    protected CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        if (hasNotCategoryMother()) {
            this.categoryMother = new CategoryDTO(category.getCategoryMother());
        }
    }

    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category);
    }

    public static List<CategoryDTO> toDTO(List<Category> categories) {
        return categories.stream()
                .map(CategoryDTO::new)
                .collect(toList());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategoryMother() {
        return categoryMother;
    }

    public void setCategoryMother(CategoryDTO categoryMother) {
        this.categoryMother = categoryMother;
    }

    public Boolean hasNotCategoryMother() {
        return hasCategoryMother();
    }

    public Boolean hasCategoryMother() {
        return !isNull(this.getCategoryMother());
    }

    public Long idCategoryMother() {
        if (hasCategoryMother()) {
            return getCategoryMother().getId();
        }

        return 0L;
    }

}
