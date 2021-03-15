package com.animalFeeding.zoo.impl;

import com.animalFeeding.zoo.Animal;
import com.animalFeeding.zoo.food.Food;
import com.animalFeeding.zoo.food.FoodType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Getter
@Setter
public class Crow implements Animal {

    private Food food;

    public Crow() {
        this.food = Food.builder()
                .expiredDate(LocalDateTime.now().plusMinutes(6))
                .foodType(FoodType.CHEESE)
                .value(BigDecimal.valueOf(5)).build();
    }

    @Override
    public void voice() {
        System.out.println("caw");
    }

}
