package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {
	// 類別大寫
	@Test
	public void classTest() {
		Dog dog = new Dog();
//		dog.setAttributes("Liiy", "yellow", 2);
		System.out.println("===============");
		System.out.println(dog.getAge());
		System.out.println(dog.getName());
		System.out.println(dog.getColor());
	}

	@Test
	public void classTest2() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		Assert.isTrue(bank.getBalance() == 1000, "saving error!!");
		bank.saving(0);
		System.out.println(bank.getBalance());

	}

	@Test
	public void classTest3() {
		TaipeiBank bank = new TaipeiBank();
		Scanner scan = new Scanner(System.in);
//		int showBalance =bank.getBalance();

		System.out.println("目前餘額為" + bank.getBalance()); // 不能改的private
		System.out.println("存款還是領錢，請輸入(s/w)");
		String inputAction = scan.next();

		if ("s".equals(inputAction)) {

			System.out.println("輸入存多少錢");
			int thisNum = scan.nextInt();
			bank.saving(thisNum);
			System.out.println("目前餘額為" + bank.getBalance());
		}

		if ("w".equals(inputAction)) {
			System.out.println("輸入領多少錢");
			int thisNum = scan.nextInt();

			if (thisNum > 0 && bank.getBalance() > thisNum) {
				bank.withdraw(thisNum);
				System.out.println("目前餘額為" + bank.getBalance());
			}
			if (thisNum < 0 || bank.getBalance() < thisNum) {
				System.out.println("餘額不足");
			}
			;
		}
	}

	@Test
	public void classTest4() {
		int a = 5;
		int b = 5;
		System.out.println("a==b :" + (a == b));
		System.out.println("===============");
		Integer a1 = 10;
		Integer b1 = 10;
		System.out.println("a1==b1 :" + (a1 == b1));
		System.out.println("===============");

	}

	@Test
	public void classTest5() {
		Dog dog = new Dog();
		dog.setName("Lily");
		dog.setColor("bule");
		dog.setAge(2);
		System.out.println(dog.getName());
		System.out.println("===============");
		Dog dogg = new Dog("QQQQ", "GGG", 3);
		System.out.println(dogg.getName());
		System.out.println("===============");
	}

	@Test
	public void classTest6() {
		Dog dog = new Dog();
		dog.setAttributes(); // 一般方法的呼叫，必須先把類別new出來
		Dog.setAttributes2(); // static 方法的呼叫，直接用類別名稱.static方法 (不用new)
		Math.random(); // random是static方法
		Random ran = new Random();
		ran.nextInt(); // nextInt不是static 方法 所以需要先new

		int a = 10;
		a = 50;
		final int b = 15;
//		b=20; //final不能再修改值

	}

	@Test
	public void classTest7() {
		
	}

}
