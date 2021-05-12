package com.thebois.springbootdrinksapi.api.rest;

import com.thebois.springbootdrinksapi.domain.Drink;
import com.thebois.springbootdrinksapi.service.DrinkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/drinks")
public class DrinkController extends AbstractRestHandler {

    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService){
        this.drinkService = drinkService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a list of all Drinks")
    public List<Drink> getAllDrinks(){
        return drinkService.getAllDrinks();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adds a Drink")
    public void addDrink(@RequestBody Drink drink){
        drinkService.addDrink(drink);
    }


}
