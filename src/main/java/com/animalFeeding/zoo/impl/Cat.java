package com.animalFeeding.zoo.impl;

import com.animalFeeding.zoo.Animal;
import com.animalFeeding.zoo.food.Food;
import com.animalFeeding.zoo.food.FoodType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Qualifier("catQualifier")
@Getter
@Setter
public class Cat implements Animal {
    private Food food;

    public Cat() {
        this.food = Food.builder()
                .expiredDate(LocalDateTime.now().plusMinutes(5))
                .foodType(FoodType.FISH)
                .value(BigDecimal.valueOf(10)).build();
    }

    @Override
    public void voice() {
        System.out.println("mi");
    }
}
