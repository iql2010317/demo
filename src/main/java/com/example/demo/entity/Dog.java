package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

public class Dog implements RunService{
	private String name = "Apple";

	private String color;

	private int age; // ��k�W��=���O�W��

	public Dog() { // �w�]�غc��k with�S���Ѽ� �o�ӥ����d��!!!
		super();// �~�Ӯ� ������O ��to object class
	}

	public Dog(String name, String color, int age) { // �غcwith���Ѽ� �۩w�q�غc��k
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
		System.out.println("����b�b�]~~~");
	}
}
