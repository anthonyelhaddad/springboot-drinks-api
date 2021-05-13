package com.thebois.springbootdrinksapi.api.rest;

import com.thebois.springbootdrinksapi.domain.drink.Drink;
import com.thebois.springbootdrinksapi.dto.drink.response.DrinkResponse;
import com.thebois.springbootdrinksapi.service.DrinkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.thebois.springbootdrinksapi.dto.drink.request.DrinkCreateRequest;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @ApiOperation(value = "Get all drinks", notes = "Returns a list of Drinks")
    public List<Drink> getAllDrinks(){
        return drinkService.getAllDrinks();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a Drink")
    public void addDrink(@RequestBody DrinkCreateRequest drinkCreateRequest){
        drinkService.addDrink(drinkCreateRequest);
    }

    @GetMapping(path = "{drinkId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a Drink")
    public DrinkResponse getDrink(@PathVariable("drinkId") Long id) {
        Drink drink = drinkService.getDrinkById(id);
        return new DrinkResponse(drink);
    }

    @GetMapping(path = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Search for drinks", notes = "Returns a list of Drinks")
    public List<Drink> search(@RequestParam String q) {
        return drinkService.search(q);
    }

    @DeleteMapping(path = "{drinkId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a drink")
    public void deleteDrinkById(@PathVariable("drinkId") Long id){
        drinkService.deleteDrinkById(id);
    }
}
