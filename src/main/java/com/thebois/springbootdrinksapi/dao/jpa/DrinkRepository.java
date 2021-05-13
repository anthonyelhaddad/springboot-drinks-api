package com.thebois.springbootdrinksapi.dao.jpa;

import com.thebois.springbootdrinksapi.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Optional<Drink> findByName(String name);

    @Query("select d FROM Drink d where lower(d.name) like lower(concat('%', ?1,'%'))")
    List<Drink> search(String keyword);
}