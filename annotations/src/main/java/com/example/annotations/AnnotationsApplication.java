package com.example.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.annotations.controller.PizzaController;

@SpringBootApplication
public class AnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(AnnotationsApplication.class, args);
		PizzaController pizzaController = (PizzaController) context.getBean("pizzaDemo");
		System.out.println(pizzaController.getPizza());
	}

}
