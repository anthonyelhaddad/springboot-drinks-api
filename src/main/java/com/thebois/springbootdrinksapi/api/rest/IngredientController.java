package com.thebois.springbootdrinksapi.api.rest;

import com.thebois.springbootdrinksapi.domain.drink.Drink;
import com.thebois.springbootdrinksapi.domain.ingredient.Ingredient;
import com.thebois.springbootdrinksapi.service.IngredientService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Returns a list of all Ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adds an Ingredient")
    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @GetMapping(path = "{ingredientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Ingredient getIngredient(@PathVariable("ingredientId") Long id) {
        return ingredientService.getIngredientById(id).addLinks();
    }

    @GetMapping(path = "{ingredientId}/drinks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Drink> getDrinks(@PathVariable("ingredientId") Long id) {
        return ingredientService.getDrinksForIngredient(id);
    }

    @DeleteMapping(path = "{ingredientId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrinkById(@PathVariable("ingredientId") Long id){
        ingredientService.deleteIngredientById(id);
    }
}
