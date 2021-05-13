package com.thebois.springbootdrinksapi.domain.drink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thebois.springbootdrinksapi.api.rest.DrinkController;
import com.thebois.springbootdrinksapi.api.rest.IngredientController;
import com.thebois.springbootdrinksapi.domain.DrinkIngredient;
import com.thebois.springbootdrinksapi.domain.ingredient.Ingredient;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Table(
        name = "drink",
        uniqueConstraints = {
                @UniqueConstraint(name = "drink_name_unique", columnNames = "name")
        }
)
public class Drink extends RepresentationModel<Drink> {
    @Id
    @SequenceGenerator(
            name = "drink_sequence",
            sequenceName = "drink_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "drink_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "imageUrl",
            columnDefinition = "TEXT"
    )
    private String imageUrl;

    @Column(
            name = "videoUrl",
            columnDefinition = "TEXT"
    )
    private String videoUrl;

    @Column(
            name = "isAlcoholic",
            nullable = false
    )
    private boolean isAlcoholic;

    @Column(
            name = "instructions",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String instructions;

    @OneToMany(
            cascade = {CascadeType.PERSIST},
            mappedBy = "drink"
    )
    @JsonIgnore
    private List<DrinkIngredient> drinkIngredients = new ArrayList<>();

    public Drink() {

    }

    public Drink(String name, String imageUrl, String videoUrl, boolean isAlcoholic, String instructions) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.isAlcoholic = isAlcoholic;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public boolean getIsAlcoholic() {
        return isAlcoholic;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setIsAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<DrinkIngredient> getDrinkIngredients() {
        return drinkIngredients;
    }

    public void setDrinkIngredients(List<DrinkIngredient> drinkIngredients) {
        this.drinkIngredients = drinkIngredients;
    }

    public void addIngredient(DrinkIngredient drinkIngredient) {
        if (!drinkIngredients.contains(drinkIngredient)) {
            drinkIngredients.add(drinkIngredient);
        }
    }

    public Drink addLinks() {
        final Long id = getId();
        add(linkTo(DrinkController.class).withRel("drinks"));
        add(linkTo(methodOn(DrinkController.class).getDrink(id)).withSelfRel());
        return this;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", isAlcoholic=" + isAlcoholic +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
