package com.example.demo.entity;

public class Animal {

	private String name="Fa";
	
	public Animal() {
//		System.out.println("Animlal 建構方法"); //會報錯
		super();
//		System.out.println("Animlal 建構方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(this.name +"正在吃!!!");
	}

	public void sleep() {
		System.out.println(this.name + "正在睡!!!");
	}
	
	
}
