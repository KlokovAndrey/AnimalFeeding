package com.animalFeeding;

import com.animalFeeding.aspect.AnimalAspect;
import com.animalFeeding.configuration.AnnotationConfiguration;
import com.animalFeeding.zoo.Eating;
import com.animalFeeding.zoo.Zoo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = getAnnotationContext("annotationConfiguration");
        Zoo setterZoo = context.getBean("zoo", Zoo.class);
        Eating eating = new Eating(setterZoo);
        AnimalAspect animalAspect = new AnimalAspect(setterZoo);
    }

    private static ApplicationContext getAnnotationContext(String profile) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles(profile);
        annotationConfigApplicationContext.register(AnnotationConfiguration.class);
        annotationConfigApplicationContext.refresh();
        return annotationConfigApplicationContext;
    }
}
