package com.example.demo.service.ifs;

import com.example.demo.entity.Meal;

public interface MealService {
	public Meal addMeal(Meal meal);//±a¤JEntitiy
	
	public Meal findByName(String name);
}
