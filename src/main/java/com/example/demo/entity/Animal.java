package com.example.demo.entity;

public class Animal {

	private String name="Fa";
	
	public Animal() {
//		System.out.println("Animlal �غc��k"); //�|����
		super();
//		System.out.println("Animlal �غc��k");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(this.name +"���b�Y!!!");
	}

	public void sleep() {
		System.out.println(this.name + "���b��!!!");
	}
	
	
}