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
//		System.out.println("Bird���غc��k");
	}

	// �Ƽg or ���s�w�q
	// ���l���O���ۦP��k�W�١A�l���O�惡��k���s�w�q�ۤv����@���e
	@Override
	public void eat() {
		System.out.println(super.getName() + "��Y�䪱!!!");
	}

	@Override
	public void sleep() {
		System.out.println(super.getName() + "��Y���!!!");
	}

	public void flying() {
		System.out.println(super.getName() + "���b��!!!");
	}
}
