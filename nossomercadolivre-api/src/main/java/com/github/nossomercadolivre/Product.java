package com.github.nossomercadolivre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @DecimalMin(value = "0.1", inclusive = true)
    private BigDecimal value;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long quantityAvaiable;

    @NotBlank
    @Size(max = 1000)
    @Column(nullable = false, length = 1000)
    private String markdownDescription;

    @PastOrPresent
    @Column(updatable = false, nullable = false)
    private Instant createdDate;

//    @NotNull
//    @Valid
////    @UniqueElements
//    private Set<Photo> photos;

//    @NotNull
//    @Valid
//    @Column(nullable = false)
//    private Category category;
//
//    private Set<Characteristic> characteristics;

    @Deprecated
    protected Product() {
    }

    public Product(@NotBlank String name, @NotNull @DecimalMin(value = "1.0", inclusive = true) BigDecimal value,
                   @NotNull @Min(1) Long quantityAvaiable, @NotBlank @Size(max = 1000) String markdownDescription
                   //@NotNull @Valid Set<Photo> photos, @NotNull @Valid Category category, Set<Characteristic> characteristics
    ) {

//        Assert.notNull(category, "Category can't be null");
//        Assert.notEmpty(photos, "Photos can't be null or empty");
        this.createdDate = Instant.now();

        this.name = name;
        this.value = value;
        this.quantityAvaiable = quantityAvaiable;
        this.markdownDescription = markdownDescription;
//        this.photos = photos;
//        this.category = category;
//        this.characteristics = characteristics;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Long getQuantityAvaiable() {
        return quantityAvaiable;
    }

    public String getMarkdownDescription() {
        return markdownDescription;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    //    public Product addPhoto(Photo photo) {
//        Assert.notNull(photo, "Photo can't be null");
//        if (Objects.isNull(photos)) {
//            this.photos = new TreeSet<>();
//        }
//        this.photos.add(photo);
//
//        return this;
//    }

}

