package com.animalFeeding.zoo;

import com.animalFeeding.zoo.food.Food;
import org.springframework.scheduling.annotation.Scheduled;

public interface Animal {
    void voice();
    Food getFood();
    void setFood(Food food);
}