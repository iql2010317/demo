package com.example.demo.entity;

public class Bird extends Animal {

	private TaipeiBank bank;
	
//	private String branch;
//
//	private String user;
//
//	private int balance =1000;
	
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
//		System.out.println("Bird的建構方法");
	}

	// 複寫 or 重新定義
	// 父子類別有相同方法名稱，子類別對此方法重新定義自己的實作內容
	@Override
	public void eat() {
		System.out.println(super.getName() + "邊吃邊玩!!!");
	}

	@Override
	public void sleep() {
		System.out.println(super.getName() + "邊吃邊睡!!!");
	}

	public void flying() {
		System.out.println(super.getName() + "正在飛!!!");
	}
}
