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
		double b = 95.0 / 10; // ��ƻP�B�I�� �`�N�I
		System.out.println(b);
	}

	@Test
	public void scannerTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r");
		String a = scan.next(); // ����ťզ�m����
		System.out.println("��J����r�O:" + a);
	}

	@Test
	public void scannerTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r");
		String a = scan.next();
		String b = scan.next();
		System.out.println("��J����r�O:" + a + b); // ABC DEF
	}

	@Test
	public void scannerTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r:");
		String a = scan.nextLine();
		System.out.println("��J����r�O:" + a);
	}

	@Test
	public void scannerTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�Ʀr:");
		int a = scan.nextInt();
		System.out.println("��J���Ʀr�O:" + a);
	}

	@Test
	public void switchTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J���Z:");
		int input = scan.nextInt();
		switch (input / 10) {
		case 10:
		case 9:
			System.out.println("A"); // case10��case9 ���OA
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
//				�i�H����break
		}
		
	}

	@Test
	public void switchTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���]���ѬO�P��x:");
		String x = scan.next();
		System.out.println("�L�Fy�Ѥ���:");
		int y = scan.nextInt();
		switch (x) {
		case "��":
			switch (y % 7) {
			case 1:
				System.out.println("���ѬO�P���@!");
				break;
			case 2:
				System.out.println("���ѬO�P���G!");
				break;
			case 3:
				System.out.println("���ѬO�P���T!");
				break;
			case 4:
				System.out.println("���ѬO�P���|!");
				break;
			case 5:
				System.out.println("���ѬO�P����!");
				break;
			case 6:
				System.out.println("���ѬO�P����!");
				break;
			case 7:
				System.out.println("���ѬO�P����!");
				break;
			}
			break;
		case "�@":
			switch (y % 7) {
			case 1:
				System.out.println("���ѬO�P���G!");
				break;
			case 2:
				System.out.println("���ѬO�P���T!");
				break;
			case 3:
				System.out.println("���ѬO�P���|!");
				break;
			case 4:
				System.out.println("���ѬO�P����!");
				break;
			case 5:
				System.out.println("���ѬO�P����!");
				break;
			case 6:
				System.out.println("���ѬO�P����!");
				break;
			case 7:
				System.out.println("���ѬO�P���@!");
				break;
			}
			break;
		case "�G":
			switch (y % 7) {
			case 1:
				System.out.println("���ѬO�P���T!");
				break;
			case 2:
				System.out.println("���ѬO�P���|!");
				break;
			case 3:
				System.out.println("���ѬO�P����!");
				break;
			case 4:
				System.out.println("���ѬO�P����!");
				break;
			case 5:
				System.out.println("���ѬO�P����!");
				break;
			case 6:
				System.out.println("���ѬO�P���@!");
				break;
			case 7:
				System.out.println("���ѬO�P���G!");
				break;
			}
			break;
		case "�T":
			switch (y % 7) {
			case 1:
				System.out.println("���ѬO�P���|!");
				break;
			case 2:
				System.out.println("���ѬO�P����!");
				break;
			case 3:
				System.out.println("���ѬO�P����!");
				break;
			case 4:
				System.out.println("���ѬO�P����!");
				break;
			case 5:
				System.out.println("���ѬO�P���@!");
				break;
			case 6:
				System.out.println("���ѬO�P���G!");
				break;
			case 7:
				System.out.println("���ѬO�P���T!");
				break;
			}
			break;
		case "�|":
			switch (y % 7) {
			case 1:
				System.out.println("���ѬO�P����!");
				break;
			case 2:
				System.out.println("���ѬO�P����!");
				break;
			case 3:
				System.out.println("���ѬO�P����!");
				break;
			case 4:
				System.out.println("���ѬO�P���@!");
				break;
			case 5:
				System.out.println("���ѬO�P���G!");
				break;
			case 6:
				System.out.println("���ѬO�P���T!");
				break;
			case 7:
				System.out.println("���ѬO�P���|!");
				break;
			}
			break;
		case "��":
			switch (y % 7) {
			case 1:
				System.out.println("���ѬO�P����!");
				break;
			case 2:
				System.out.println("���ѬO�P����!");
				break;
			case 3:
				System.out.println("���ѬO�P���@!");
				break;
			case 4:
				System.out.println("���ѬO�P���G!");
				break;
			case 5:
				System.out.println("���ѬO�P���T!");
				break;
			case 6:
				System.out.println("���ѬO�P���|!");
				break;
			case 7:
				System.out.println("���ѬO�P����!");
				break;
			}
			break;
		case "��":
			switch (y % 7) {
			case 1:
				System.out.println("���ѬO�P����");
				break;
			case 2:
				System.out.println("���ѬO�P���@!");
				break;
			case 3:
				System.out.println("���ѬO�P���G!");
				break;
			case 4:
				System.out.println("���ѬO�P���T!");
				break;
			case 5:
				System.out.println("���ѬO�P���|!");
				break;
			case 6:
				System.out.println("���ѬO�P����!");
				break;
			case 7:
				System.out.println("���ѬO�P����!");
				break;
			}
		}
	}

	@Test
	public void switchTest3() {
	    Scanner scan = new Scanner(System.in);
	    System.out.println("���]���ѬO�P��x:");
	    String x = scan.next();
	    System.out.println("�L�Fy�Ѥ���:");
	    int y = scan.nextInt();
	    
	    //�}�C�g�k
//	    String[] strArray= {"��","��","�@","�G","�T","�|","��","��"};
//	    List<> //list�g�k
//	    System.out.printf("���ѬO�P��%s, %d�ѫ�O�P����",inputStr,days);
//	    %d (digital) �w��Ʀr���A %s (String) �w��r�ꫬ�A
	    
	    int daysPassed = (y % 7);
	    
	    switch (x) {
	        case "��":
	            break;
	        case "�@":
	            daysPassed++;
	            break;
	        case "�G":
	            daysPassed += 2;
	            break;
	        case "�T":
	            daysPassed += 3;
	            break;
	        case "�|":
	            daysPassed += 4;
	            break;
	        case "��":
	            daysPassed += 5;
	            break;
	        case "��":
	            daysPassed += 6;
	            break;
	    }
	    
	    int dayOfWeek = daysPassed % 7;
	    
	    switch (dayOfWeek) {
	        case 0:
	            System.out.println("���ѬO�P���ѡA�ڷQ��!");
	            break;
	        case 1:
	            System.out.println("���ѬO�P���@!�A�ڷQ��!");
	            break;
	        case 2:
	            System.out.println("���ѬO�P���G!�A�ڷQ��!");
	            break;
	        case 3:
	            System.out.println("���ѬO�P���T!�A�ڷQ��!");
	            break;
	        case 4:
	            System.out.println("���ѬO�P���|!�A�ڷQ��!");
	            break;
	        case 5:
	            System.out.println("���ѬO�P����!�A�ڷQ��!");
	            break;
	        case 6:
	            System.out.println("���ѬO�P����!�A�ڷQ��!");
	            break;
	    }
	}
	
	
	
	
}
