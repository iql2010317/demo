package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dog;

public class StringTest {

	@Test
	public void stringTest() {
		String str = "ABC";
		String str1 = "";
		String str2 = "  ";
		System.out.println("str1 length:" + str1.length());
		System.out.println("str2 length:" + str2.length());
		System.out.println("=================");
		System.out.println("str1 isEmpty:" + str1.isEmpty());
		System.out.println("str2 isEmpty:" + str2.isEmpty());
		System.out.println("=================");
		System.out.println("str1 isBlank:" + str1.isBlank());
		System.out.println("str2 isBlank:" + str2.isBlank());
	}

	@Test
	public void stringTest2() {
		Dog dog = new Dog();
		String name = dog.getName();
		String color = dog.getColor();
		System.out.println(name);
		System.out.println(color);
		System.out.println("===============");
//		System.out.println(name.length());
//		System.out.println(color.length());
		System.out.println("hasText���G" + StringUtils.hasText(""));
		System.out.println("hasText���G" + StringUtils.hasText("   "));
		System.out.println("hasText���G" + StringUtils.hasText("ABC"));

	}

//	"����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
	@Test
	public void stringTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�������դ�r�q");
		String keyinText = scan.next();
		int count = 0;
		boolean found = false;

		System.out.println("��J�n�d�ߪ��r��");
		String search = scan.next();
		int index = 0; //

		while (index != -1) {
			index = keyinText.indexOf(search, index);
			if (index != -1) {
				count++;
				index += search.length(); //
				found = true; //
			}
		}

		if (found) {
			System.out.println(search + "�X�{������: " + count);
		} else {
			System.out.println("�䤣����j�M�r��");
		}
	}

	@Test
	public void replaceTest() {
		String str = "����L�Q�O���L�P�p�s�k���G�ơA" + "�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
		str = str.replace("�p�s�k", "�pŢ�]");
		System.out.println(str);
		System.out.println("==============");
		str = str.replaceAll("�pŢ�]", "�pŢ���]");
		System.out.println(str);
	}

	@Test
	public void splitTest() {
		String str = "����L�Q�O���L�P�p�s�k���G�ơA" + "�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
		String[] array = str.split("�A");
		for (String item : array) { // forEach�j��
			System.out.println(item);
		}
		System.out.println("=============");
		String str1 = "ABCD";
		String[] array1 = str1.split("");
		for (String item : array1) {
			System.out.println(item);
		}
	}

	@Test
	public void trimTest() {
		String str = "ABC    DEF G";
		String str1 = " ABC DEF  ";
		String str2 = "����L�Q�O���L�P�p�s�k���G�ơA" + "�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
		str = str.trim();
		str1 = str1.trim();
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str == str1);
		System.out.println(str.equals(str1));
		System.out.println("====================");
		str = str.replace(" ", "");
		System.out.println(str);
		System.out.println("====================");
		String a = str2.substring(5);
		System.out.println("a" + a);
	}

	@Test
	public void substringTest() {
		String str = "����L�Q�O���L�P�p�s�k���G��";
		String subStr = str.substring(5);
		String subStr1 = str.substring(5, 11);
		System.out.println("�^��5~: " + subStr);
		System.out.println("�^��5~11: " + subStr1);
	}

	@Test
	public void stringBufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		sb.append("GGG");
		sb.append("AAA").append("BBB");
		System.out.println("======================");
	}

	@Test
	public void stringBufferTest1() {
		StringBuffer sb = new StringBuffer("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		System.out.println(sb.equals(sb1));
		System.out.println(sb.toString().equals(sb1.toString()));

	}

	@Test
	public void replaceTest03() { 
		String replaceText = "ABACADEF";
		int index = replaceText.indexOf("A");
		int count = 0;
//		int test = replaceText.indexOf("A",8);
//		System.out.println(test);

		while (index != -1) {
			index = replaceText.lastIndexOf("A", index);
			if (index != -1) {
				index++;
				count++;
			}
			System.out.println("����m: " + index);
		}
//		System.out.println("�o��"+index);
//		index =replaceText.lastIndexOf("A", index);
//		System.out.println("�^��5"+index);
	}

	@Test
	public void replaceTest04() { 
		Scanner scan=new Scanner(System.in);
		System.out.println("��J��r�q");
		String keyinText = scan.next();
		
		StringBuffer sb = new StringBuffer(keyinText);
		
		if(keyinText.equals(sb.reverse().toString())) {
			System.out.println("�O�j��");
		}else {
			System.out.println("���O�j��");
		}	
	}
	
	@Test
	public void replaceTest05() { 
		Scanner scan=new Scanner(System.in);
		System.out.println("��J�Ʀr");
		int inputInt =scan.nextInt();
		inputInt++;
		String str = String.valueOf(inputInt);
		String[]strArray = str.split("");
		System.out.println(new ArrayList<>(Arrays.asList(strArray)));
		
	}
}
