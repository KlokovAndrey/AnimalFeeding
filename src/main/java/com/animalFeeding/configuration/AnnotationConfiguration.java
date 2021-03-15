package com.animalFeeding.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(value = {"com"})
@EnableScheduling
@EnableAspectJAutoProxy
public class AnnotationConfiguration {
}
