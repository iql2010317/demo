package com.example.demo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MealId implements Serializable{
	
	private String name;
	
	private String cookingStyle;
	
	

	public MealId() {
		super();
	}

	public MealId(String name, String cookingSyle) {
		super();
		this.name = name;
		this.cookingStyle = cookingSyle;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCookingSyle() {
		return cookingStyle;
	}

	public void setCookingSyle(String cookingSyle) {
		this.cookingStyle = cookingSyle;
	}
	
	
	
	
}
