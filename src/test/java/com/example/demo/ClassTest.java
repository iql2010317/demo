package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {
	// ���O�j�g
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

		System.out.println("�ثe�l�B��" + bank.getBalance()); // ����諸private
		System.out.println("�s���٬O����A�п�J(s/w)");
		String inputAction = scan.next();

		if ("s".equals(inputAction)) {

			System.out.println("��J�s�h�ֿ�");
			int thisNum = scan.nextInt();
			bank.saving(thisNum);
			System.out.println("�ثe�l�B��" + bank.getBalance());
		}

		if ("w".equals(inputAction)) {
			System.out.println("��J��h�ֿ�");
			int thisNum = scan.nextInt();

			if (thisNum > 0 && bank.getBalance() > thisNum) {
				bank.withdraw(thisNum);
				System.out.println("�ثe�l�B��" + bank.getBalance());
			}
			if (thisNum < 0 || bank.getBalance() < thisNum) {
				System.out.println("�l�B����");
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
		dog.setAttributes(); // �@���k���I�s�A�����������Onew�X��
		Dog.setAttributes2(); // static ��k���I�s�A���������O�W��.static��k (����new)
		Math.random(); // random�Ostatic��k
		Random ran = new Random();
		ran.nextInt(); // nextInt���Ostatic ��k �ҥH�ݭn��new

		int a = 10;
		a = 50;
		final int b = 15;
//		b=20; //final����A�ק��

	}

	@Test
	public void classTest7() {
		
	}

}
