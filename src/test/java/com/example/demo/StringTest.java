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
		System.out.println("hasText結果" + StringUtils.hasText(""));
		System.out.println("hasText結果" + StringUtils.hasText("   "));
		System.out.println("hasText結果" + StringUtils.hasText("ABC"));

	}

//	"神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
	@Test
	public void stringTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入本次測試文字段");
		String keyinText = scan.next();
		int count = 0;
		boolean found = false;

		System.out.println("輸入要查詢的字串");
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
			System.out.println(search + "出現的次數: " + count);
		} else {
			System.out.println("找不到欲搜尋字串");
		}
	}

	@Test
	public void replaceTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事，" + "我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		str = str.replace("小龍女", "小籠包");
		System.out.println(str);
		System.out.println("==============");
		str = str.replaceAll("小籠包", "小籠湯包");
		System.out.println(str);
	}

	@Test
	public void splitTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事，" + "我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		String[] array = str.split("，");
		for (String item : array) { // forEach迴圈
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
		String str2 = "神鵰俠侶是楊過與小龍女的故事，" + "我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
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
		String str = "神鵰俠侶是楊過與小龍女的故事";
		String subStr = str.substring(5);
		String subStr1 = str.substring(5, 11);
		System.out.println("擷取5~: " + subStr);
		System.out.println("擷取5~11: " + subStr1);
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
			System.out.println("找到位置: " + index);
		}
//		System.out.println("這裡"+index);
//		index =replaceText.lastIndexOf("A", index);
//		System.out.println("回到5"+index);
	}

	@Test
	public void replaceTest04() { 
		Scanner scan=new Scanner(System.in);
		System.out.println("輸入文字段");
		String keyinText = scan.next();
		
		StringBuffer sb = new StringBuffer(keyinText);
		
		if(keyinText.equals(sb.reverse().toString())) {
			System.out.println("是迴文");
		}else {
			System.out.println("不是迴文");
		}	
	}
	
	@Test
	public void replaceTest05() { 
		Scanner scan=new Scanner(System.in);
		System.out.println("輸入數字");
		int inputInt =scan.nextInt();
		inputInt++;
		String str = String.valueOf(inputInt);
		String[]strArray = str.split("");
		System.out.println(new ArrayList<>(Arrays.asList(strArray)));
		
	}
}
