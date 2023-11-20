package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ConditionTest {

	@Test
	public void ifTest() {
		int a = 5;
		if (a > 5) {
			System.out.println("=========");
		} else {
			System.out.println("+++++++++");
		}
	}

	@Test
	public void ifTest1() {
		int a = 5;
		if (a > 5) {
			System.out.println("=========");
		} else if (a > 3) {
			System.out.println("+++++++++");
		} else {
			System.out.println("---------");
		}
	}

	@Test
	public void switchTest0() {
		int a = 95;
		double b = 95.0 / 10; // 整數與浮點數 注意點
		System.out.println(b);
	}

	@Test
	public void scannerTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字");
		String a = scan.next(); // 取到空白位置為止
		System.out.println("輸入的文字是:" + a);
	}

	@Test
	public void scannerTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字");
		String a = scan.next();
		String b = scan.next();
		System.out.println("輸入的文字是:" + a + b); // ABC DEF
	}

	@Test
	public void scannerTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字:");
		String a = scan.nextLine();
		System.out.println("輸入的文字是:" + a);
	}

	@Test
	public void scannerTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入數字:");
		int a = scan.nextInt();
		System.out.println("輸入的數字是:" + a);
	}

	@Test
	public void switchTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入成績:");
		int input = scan.nextInt();
		switch (input / 10) {
		case 10:
		case 9:
			System.out.println("A"); // case10或case9 都是A
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
//				可以不用break
		}
		
	}

	@Test
	public void switchTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("假設今天是星期x:");
		String x = scan.next();
		System.out.println("過了y天之後:");
		int y = scan.nextInt();
		switch (x) {
		case "天":
			switch (y % 7) {
			case 1:
				System.out.println("今天是星期一!");
				break;
			case 2:
				System.out.println("今天是星期二!");
				break;
			case 3:
				System.out.println("今天是星期三!");
				break;
			case 4:
				System.out.println("今天是星期四!");
				break;
			case 5:
				System.out.println("今天是星期五!");
				break;
			case 6:
				System.out.println("今天是星期六!");
				break;
			case 7:
				System.out.println("今天是星期天!");
				break;
			}
			break;
		case "一":
			switch (y % 7) {
			case 1:
				System.out.println("今天是星期二!");
				break;
			case 2:
				System.out.println("今天是星期三!");
				break;
			case 3:
				System.out.println("今天是星期四!");
				break;
			case 4:
				System.out.println("今天是星期五!");
				break;
			case 5:
				System.out.println("今天是星期六!");
				break;
			case 6:
				System.out.println("今天是星期天!");
				break;
			case 7:
				System.out.println("今天是星期一!");
				break;
			}
			break;
		case "二":
			switch (y % 7) {
			case 1:
				System.out.println("今天是星期三!");
				break;
			case 2:
				System.out.println("今天是星期四!");
				break;
			case 3:
				System.out.println("今天是星期五!");
				break;
			case 4:
				System.out.println("今天是星期六!");
				break;
			case 5:
				System.out.println("今天是星期天!");
				break;
			case 6:
				System.out.println("今天是星期一!");
				break;
			case 7:
				System.out.println("今天是星期二!");
				break;
			}
			break;
		case "三":
			switch (y % 7) {
			case 1:
				System.out.println("今天是星期四!");
				break;
			case 2:
				System.out.println("今天是星期五!");
				break;
			case 3:
				System.out.println("今天是星期六!");
				break;
			case 4:
				System.out.println("今天是星期天!");
				break;
			case 5:
				System.out.println("今天是星期一!");
				break;
			case 6:
				System.out.println("今天是星期二!");
				break;
			case 7:
				System.out.println("今天是星期三!");
				break;
			}
			break;
		case "四":
			switch (y % 7) {
			case 1:
				System.out.println("今天是星期五!");
				break;
			case 2:
				System.out.println("今天是星期六!");
				break;
			case 3:
				System.out.println("今天是星期天!");
				break;
			case 4:
				System.out.println("今天是星期一!");
				break;
			case 5:
				System.out.println("今天是星期二!");
				break;
			case 6:
				System.out.println("今天是星期三!");
				break;
			case 7:
				System.out.println("今天是星期四!");
				break;
			}
			break;
		case "五":
			switch (y % 7) {
			case 1:
				System.out.println("今天是星期六!");
				break;
			case 2:
				System.out.println("今天是星期天!");
				break;
			case 3:
				System.out.println("今天是星期一!");
				break;
			case 4:
				System.out.println("今天是星期二!");
				break;
			case 5:
				System.out.println("今天是星期三!");
				break;
			case 6:
				System.out.println("今天是星期四!");
				break;
			case 7:
				System.out.println("今天是星期五!");
				break;
			}
			break;
		case "六":
			switch (y % 7) {
			case 1:
				System.out.println("今天是星期天");
				break;
			case 2:
				System.out.println("今天是星期一!");
				break;
			case 3:
				System.out.println("今天是星期二!");
				break;
			case 4:
				System.out.println("今天是星期三!");
				break;
			case 5:
				System.out.println("今天是星期四!");
				break;
			case 6:
				System.out.println("今天是星期五!");
				break;
			case 7:
				System.out.println("今天是星期六!");
				break;
			}
		}
	}

	@Test
	public void switchTest3() {
	    Scanner scan = new Scanner(System.in);
	    System.out.println("假設今天是星期x:");
	    String x = scan.next();
	    System.out.println("過了y天之後:");
	    int y = scan.nextInt();
	    
	    //陣列寫法
//	    String[] strArray= {"日","天","一","二","三","四","五","六"};
//	    List<> //list寫法
//	    System.out.printf("今天是星期%s, %d天後是星期天",inputStr,days);
//	    %d (digital) 針對數字型態 %s (String) 針對字串型態
	    
	    int daysPassed = (y % 7);
	    
	    switch (x) {
	        case "天":
	            break;
	        case "一":
	            daysPassed++;
	            break;
	        case "二":
	            daysPassed += 2;
	            break;
	        case "三":
	            daysPassed += 3;
	            break;
	        case "四":
	            daysPassed += 4;
	            break;
	        case "五":
	            daysPassed += 5;
	            break;
	        case "六":
	            daysPassed += 6;
	            break;
	    }
	    
	    int dayOfWeek = daysPassed % 7;
	    
	    switch (dayOfWeek) {
	        case 0:
	            System.out.println("今天是星期天，我想放假!");
	            break;
	        case 1:
	            System.out.println("今天是星期一!，我想放假!");
	            break;
	        case 2:
	            System.out.println("今天是星期二!，我想放假!");
	            break;
	        case 3:
	            System.out.println("今天是星期三!，我想放假!");
	            break;
	        case 4:
	            System.out.println("今天是星期四!，我想放假!");
	            break;
	        case 5:
	            System.out.println("今天是星期五!，我想放假!");
	            break;
	        case 6:
	            System.out.println("今天是星期六!，我想放假!");
	            break;
	    }
	}
	
	
	
	
}
