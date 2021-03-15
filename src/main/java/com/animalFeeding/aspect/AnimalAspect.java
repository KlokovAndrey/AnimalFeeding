package com.animalFeeding.aspect;

import com.animalFeeding.zoo.Zoo;
import com.animalFeeding.zoo.food.Food;
import com.animalFeeding.zoo.food.FoodType;
import com.animalFeeding.zoo.impl.Cat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Aspect
@Component
public class AnimalAspect {

    Zoo zoo;

    public AnimalAspect(Zoo zoo) {
        this.zoo = zoo;
    }

    @Pointcut("execution(* com.animalFeeding.zoo.impl.Cat.voice())")
    public void catVoicePoint() {
    }

    @AfterReturning(value = "catVoicePoint()")
    public void feedingCat(JoinPoint joinPoint) {
        zoo.getAnimal1().setFood(Food.builder()
                .foodType(FoodType.FISH)
                .expiredDate(LocalDateTime.now().plusMinutes(5))
                .value(BigDecimal.valueOf(50)).build());
        System.out.println("Food has been added");

    }

    @Pointcut("execution(* com.animalFeeding.zoo.impl.Dog.voice())")
    public void dogVoicePoint() {
    }

    @AfterReturning(value = "dogVoicePoint()")
    public void feedingDog(JoinPoint joinPoint) {
        zoo.getAnimal2().setFood(Food.builder()
                .foodType(FoodType.MEAT)
                .expiredDate(LocalDateTime.now().plusMinutes(8))
                .value(BigDecimal.valueOf(150)).build());
        System.out.println("Food has been added");

    }

    @Pointcut("execution(* com.animalFeeding.zoo.impl.Crow.voice())")
    public void crowVoicePoint() {
    }

    @AfterReturning(value = "crowVoicePoint()")
    public void feedingCrow(JoinPoint joinPoint) {
        zoo.getAnimal3().setFood(Food.builder()
                .foodType(FoodType.CHEESE)
                .expiredDate(LocalDateTime.now().plusMinutes(15))
                .value(BigDecimal.valueOf(100)).build());
        System.out.println("Food has been added");

    }

}
