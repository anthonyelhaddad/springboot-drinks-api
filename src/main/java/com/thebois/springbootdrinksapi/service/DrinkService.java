package com.thebois.springbootdrinksapi.service;

import com.thebois.springbootdrinksapi.dao.jpa.DrinkRepository;
import com.thebois.springbootdrinksapi.domain.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository){
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getAllDrinks() {return drinkRepository.findAll();}

    public void addDrink(Drink drink){
        Optional<Drink> optionalDrink = drinkRepository.findByName(drink.getName());
        if(optionalDrink.isPresent()){
            throw new IllegalStateException("Drink with this name already exists");
        }
        drinkRepository.save(drink);
    }
}
