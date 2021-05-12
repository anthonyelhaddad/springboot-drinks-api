package com.thebois.springbootdrinksapi.api.rest;

import com.thebois.springbootdrinksapi.domain.Drink;
import com.thebois.springbootdrinksapi.domain.Ingredient;
import com.thebois.springbootdrinksapi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/ingredients")
public class IngredientController extends AbstractRestHandler {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @GetMapping(path = "{ingredientId}")
    public Ingredient getIngredient(@PathVariable("ingredientId") Long id) {
        return ingredientService.getIngredientById(id);
    }
}
