package com.animalFeeding.zoo;


import com.animalFeeding.zoo.food.Food;
import com.animalFeeding.zoo.food.FoodType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class Eating {
    Zoo zoo;

    public Eating(Zoo zoo) {
        this.zoo = zoo;
    }

    @Scheduled(cron = "1 * * * * *")
    public void catEat() {
        if((this.zoo.getAnimal1().getFood().getValue().compareTo(BigDecimal.valueOf(10)) == 1 ||
                this.zoo.getAnimal1().getFood().getValue().compareTo(BigDecimal.valueOf(10)) == 0) &&
                this.zoo.getAnimal1().getFood().getExpiredDate().isAfter(LocalDateTime.now()) &&
                this.zoo.getAnimal1().getFood().getFoodType().equals(FoodType.FISH))
        {
            Food restOfFood = this.zoo.getAnimal1().getFood();
            restOfFood.setValue(this.zoo.getAnimal1().getFood().getValue().subtract(BigDecimal.valueOf(10)));
            this.zoo.getAnimal1().setFood(restOfFood);
            System.out.println("cat is eating");
        } else {
            this.zoo.getAnimal1().voice();
        }
    }

    @Scheduled(cron = "1 * * * * *")
    public void dogEat() {
        if((this.zoo.getAnimal2().getFood().getValue().compareTo(BigDecimal.valueOf(20)) == 1 ||
                this.zoo.getAnimal2().getFood().getValue().compareTo(BigDecimal.valueOf(20)) == 0 ) &&
                this.zoo.getAnimal2().getFood().getExpiredDate().isAfter(LocalDateTime.now()) &&
                this.zoo.getAnimal2().getFood().getFoodType().equals(FoodType.MEAT))
        {
            Food restOfFood = this.zoo.getAnimal2().getFood();
            restOfFood.setValue(this.zoo.getAnimal2().getFood().getValue().subtract(BigDecimal.valueOf(20)));
            this.zoo.getAnimal2().setFood(restOfFood);
            System.out.println("dog is eating");
        } else {
            this.zoo.getAnimal2().voice();
        }
    }

    @Scheduled(cron = "1 * * * * *")
    public void crowEat() {
        if((this.zoo.getAnimal3().getFood().getValue().compareTo(BigDecimal.valueOf(5)) == 1 ||
                this.zoo.getAnimal3().getFood().getValue().compareTo(BigDecimal.valueOf(5)) == 0 ) &&
                this.zoo.getAnimal3().getFood().getExpiredDate().isAfter(LocalDateTime.now()) &&
        this.zoo.getAnimal3().getFood().getFoodType().equals(FoodType.CHEESE))
        {
            Food restOfFood = this.zoo.getAnimal3().getFood();
            restOfFood.setValue(this.zoo.getAnimal3().getFood().getValue().subtract(BigDecimal.valueOf(5)));
            this.zoo.getAnimal3().setFood(restOfFood);
            System.out.println("crow is eating");
        } else {
            this.zoo.getAnimal3().voice();
        }
    }

}
