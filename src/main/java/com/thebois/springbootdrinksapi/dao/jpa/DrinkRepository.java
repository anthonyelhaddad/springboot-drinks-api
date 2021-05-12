package com.thebois.springbootdrinksapi.dao.jpa;

import com.thebois.springbootdrinksapi.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Optional<Drink> findByName(String name);
}