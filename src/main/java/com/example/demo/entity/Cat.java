package com.example.demo.entity;

public class Cat extends Animal {
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
//		System.out.println("Cat的建構方法");
	}

	public void mew() {
		System.out.println(super.getName() +" 正在喵!!!");
	}
}
