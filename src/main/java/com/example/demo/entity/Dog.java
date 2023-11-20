package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

public class Dog implements RunService{
	private String name = "Apple";

	private String color;

	private int age; // 方法名稱=類別名稱

	public Dog() { // 預設建構方法 with沒有參數 這個必須留著!!!
		super();// 繼承時 找副類別 →to object class
	}

	public Dog(String name, String color, int age) { // 建構with有參數 自定義建構方法
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public void setAttributes(String name, String color, int age) {
//		this.name = name;
//		this.color = color;
//		this.age = age;
//	};
	public void setAttributes() {
		System.out.println("===============");
	}

	public static void setAttributes2() {
		System.out.println("===============");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("狗兒在奔跑~~~");
	}
}
