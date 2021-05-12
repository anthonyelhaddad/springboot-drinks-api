package com.thebois.springbootdrinksapi.api.rest;

import com.thebois.springbootdrinksapi.domain.Drink;
import com.thebois.springbootdrinksapi.response.drink.DrinkResponse;
import com.thebois.springbootdrinksapi.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.thebois.springbootdrinksapi.drink.DrinkCreateRequest;

import java.util.List;


@RestController
@RequestMapping("api/v1/drinks")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService){
        this.drinkService = drinkService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Drink> getAllDrinks(){
        return drinkService.getAllDrinks();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addDrink(@RequestBody DrinkCreateRequest drinkCreateRequest){
        drinkService.addDrink(drinkCreateRequest);
    }

    @GetMapping(path = "{drinkId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DrinkResponse getDrink(@PathVariable("drinkId") Long id) {
        Drink drink = drinkService.getDrinkById(id);
        return new DrinkResponse(drink);
    }

}
