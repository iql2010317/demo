package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class yxzTest {
	@Test
	// 1.�D�ءG�j����D�G���@��ߤl�A�q�X�ͫ��3�Ӥ�_�C�Ӥ볣�ͤ@��ߤl�A
	// �p�ߤl����ĤT�Ӥ��C�Ӥ�S�ͤ@��ߤl�A���p�ߤl�������A�ݨC�Ӥ몺�ߤl��Ƭ��h�֡H
	public void FibonacciRabbits() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�X�Ӥ��");
		int months = scan.nextInt(); // ��J��m
		int[] rabbit = new int[months]; // ��ư}�C

		rabbit[0] = 1; // �Ĥ@�Ӥ릳1��ߤl
		rabbit[1] = 1; // �ĤG�Ӥ릳1��ߤl

		for (int i = 2; i < months; i++) {
			rabbit[i] = rabbit[i - 1] + rabbit[i - 2];
		}
		System.out.println("�� " + months + " �Ӥ� �G" + rabbit[months - 1]);
		// 1.�L�X�C�Ӥ�� �ߤl���`���(�j��� �i��index)
		// 2.�L�X��N�Ӥ�� �ߤl���`���(�j��~ ���Yindex)
	}

	@Test
	// 2.�D�ءG�P�_101-200�������h�֭ӽ�ơA�ÿ�X�Ҧ���ơC
	public void PrimeNumbersInRange() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�d��x~y��������ơA�п�J��Ӽ�");
		int minNumber = scan.nextInt(); // ��J��m
		int maxNumber = scan.nextInt(); // ��J��m
		int count = 0;

		for (int i = minNumber; i < maxNumber; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("��즸��" + count);
	}

	private static boolean isPrime(int num) {
		// TODO Auto-generated method stub

		for (int j = 2; j < num; j++) {
			if (num % j == 0) {
				// �p�G�i�H�Q�㰣�Anumber���O���
				return false;
			}
		}
		// �p�G��Ӱj��]�����S���Q�㰣�Anumber�O���]
		return true;
	}

	@Test
	// 5.�D�ءG�Q�α���B��l���_���ӧ������D�G
	// �ǲߦ��Z>=90�����P�ǥ�A��ܡA
	// 60-89����������B��ܡA
	// 60���H�U����C��ܡC
	public void ternaryOperator() {
		Scanner scan = new Scanner(System.in);
		System.out.println("��J����");
		int score = scan.nextInt(); // ��J��m
		System.out.println((score >= 90) ? "A" : (score >= 60 ? "B" : "C"));
//		a ? b : c
//		�� a ���u�h���� b�A�� a ���_�h���� c
		// (����A) ? "�^��A" : (����B) ? "�^��B" : "�^��C";
//		if(score>=90) {
//			System.out.println("A");
//		}
//		else if(score>=60 && score<90) {
//			System.out.println("B");
//		}
//		else {
//			System.out.println("C");
//		}
	}

	@Test
	// 6.�D�ءG��J��ӥ����m�Mn�A�D��̤j�����ƩM�̤p�����ơC
	public void GCDandLCM() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��ӥ���� m �M n�G");
		int m = scan.nextInt();
		int n = scan.nextInt();

		int gcd = findGCD(m, n);
		int lcm = (m * n) / gcd;

		System.out.println("�̤j���]�ơ]GCD�^: " + gcd);
		System.out.println("�̤p�����ơ]LCM�^: " + lcm);
	}

	private static int findGCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

	@Test
	// 7.�D�ءG��J�@��r���A���O�έp�X��^��r���B�Ů�B�Ʀr�M�䥦�r�����ӼơC
	public void CharacterStatistics() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�@��r���G");
		String input = scan.nextLine();
//
		int letterCount = 0;
		int spaceCount = 0;
		int digitCount = 0;
		int otherCount = 0;

//      for (�������� �ܼƦW�� : �M�������X�μƲ�) {
//            // ����������ާ@
//      }
//		String keyinText ="abc123";
//		char[] arr = keyinText.toCharArray();
//		
//		for(int i=0;i<arr.length;i++) {
//			if(Character.isDigit(i))
//		}

//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
//		System.out.println(arr[5]);
//		System.out.println(arr[6]); //�|����
//        System.out.println("�o��: "+Character.isDigit('1'));

		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) {
				letterCount++;
			} else if (Character.isDigit(c)) {
				digitCount++;
			} else if (Character.isWhitespace(c)) {
				spaceCount++;
			} else {
				otherCount++;
			}
		}
//
		System.out.println("�^��r���ӼơG" + letterCount);
		System.out.println("�Ů�ӼơG" + spaceCount);
		System.out.println("�Ʀr�ӼơG" + digitCount);
		System.out.println("��L�r���ӼơG" + otherCount);
	}

	@Test
	// 8.�D�ءG�Ds=a+aa+aaa+aaaa+aa�Ka���ȡA
	// �䤤a�O�@�ӼƦr�C���]a=2�A������3�A�h��X���G���Φ��p�G2+22+222=246�F
	public void add() {
		Scanner scan = new Scanner(System.in);
		int a;
		int n;
		int total = 0;
		System.out.println("�п�Ja");
		a = scan.nextInt();// get a
		System.out.println("�п�Jn");
		n = scan.nextInt();// get n
		int changeA = a; // �@�}�l�Oa

		for (int i = 1; i <= n; i++) {
	        if (i < n) {
	            System.out.print(changeA + "+");
	        } else {
	            System.out.print(changeA);
	        }
	        total += changeA;
	        changeA = changeA * 10 + a;
	    }

	    System.out.print("=");
	    System.out.println(total);
		
		
//		for (int i = 1; i <= n; i++) {
//			total += changeA;
//			changeA = changeA * 10 + a;
//		}
//		System.out.printf("total = %d", total);
	}

}
