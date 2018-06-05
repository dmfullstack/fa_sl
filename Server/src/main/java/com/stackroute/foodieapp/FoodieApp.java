package com.stackroute.foodieapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stackroute.foodieapp.dao.service.FoodieAppService;
@SpringBootApplication
public class FoodieApp {

	public static void main(String[] args) {
		SpringApplication.run(FoodieApp.class, args);
	}
}