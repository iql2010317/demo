package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.Car;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;

public class ExtendsTest {
	
	@Test
	public void extendsTest() {
		Animal anim=new Animal();
		System.out.println("�����O Animal name "+anim.getName());
		anim.eat();
		anim.sleep();
		Bird bird = new Bird();
		bird.setName("�p��");
		System.out.println("�l���O Bird name "+bird.getName());
		bird.eat();
		bird.sleep();
		bird.flying();
		Cat cat=new Cat();
		cat.setName("mimi");
		System.out.println("�l���O cat name "+cat.getName());
		cat.eat();
		cat.sleep();
		cat.mew();	
	}
	
	@Test
	public void extendsTest1() {
		Animal anim = new Animal();
		anim.eat();
		Bird bird = new Bird();
		bird.eat();
		Cat cat = new Cat();
		cat.eat();
		cat.mew();
		System.out.println("=================");
		Animal animm = new Animal();    //�h��
		animm.eat();
		Animal birdd = new Bird();
		birdd.eat();
		Animal catt = new Cat();
		catt.eat();
		System.out.println("=================");
	}
	
	@Test
	public void interfaceTest() {
		Dog dog = new Dog();
		Car car =new Car();
		car.run();
		dog.run();
	}
	
	
	
	
}
