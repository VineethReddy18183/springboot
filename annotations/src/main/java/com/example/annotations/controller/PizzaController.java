package com.example.annotations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.annotations.service.Pizza;

@Component("pizzaDemo")
public class PizzaController {

	/*private VegPizza pizzaService;
	
	@Autowired
	public PizzaController(VegPizza pizzaService) {
		this.pizzaService = pizzaService;
	}
	
	public String getPizzaService() {
		return pizzaService.getPizza();
	}
	
	@Autowired
	public void setPizzaService(VegPizza pizzaService) {
		this.pizzaService = pizzaService;
	}*/

	private Pizza pizza;

	@Autowired
	public PizzaController(@Qualifier("vegPizza") Pizza pizza) {
		super();
		this.pizza = pizza;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}