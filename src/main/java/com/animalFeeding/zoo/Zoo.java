package com.animalFeeding.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Zoo {
    private final Animal animal1;
    private final Animal animal2;
    private final Animal animal3;

    @Autowired
    public Zoo(
            Animal cat,
            Animal dog,
            Animal crow)
            {
        this.animal1 = cat;
        this.animal2 = dog;
        this.animal3 = crow;
    }

    public Animal getAnimal1() {
        return animal1;
    }

    public Animal getAnimal2() {
        return animal2;
    }

    public Animal getAnimal3() {
        return animal3;
    }
}



