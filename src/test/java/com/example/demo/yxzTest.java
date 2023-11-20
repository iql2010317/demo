package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class yxzTest {
	@Test
	// 1.題目：古典問題：有一對兔子，從出生後第3個月起每個月都生一對兔子，
	// 小兔子長到第三個月後每個月又生一對兔子，假如兔子都不死，問每個月的兔子對數為多少？
	public void FibonacciRabbits() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入幾個月後");
		int months = scan.nextInt(); // 輸入位置
		int[] rabbit = new int[months]; // 整數陣列

		rabbit[0] = 1; // 第一個月有1對兔子
		rabbit[1] = 1; // 第二個月有1對兔子

		for (int i = 2; i < months; i++) {
			rabbit[i] = rabbit[i - 1] + rabbit[i - 2];
		}
		System.out.println("第 " + months + " 個月 ：" + rabbit[months - 1]);
		// 1.印出每個月後 兔子的總對數(迴圈裡 可用index)
		// 2.印出第N個月後 兔子的總對數(迴圈外 不吃index)
	}

	@Test
	// 2.題目：判斷101-200之間有多少個質數，並輸出所有質數。
	public void PrimeNumbersInRange() {
		Scanner scan = new Scanner(System.in);
		System.out.println("查詢x~y之間的質數，請輸入兩個數");
		int minNumber = scan.nextInt(); // 輸入位置
		int maxNumber = scan.nextInt(); // 輸入位置
		int count = 0;

		for (int i = minNumber; i < maxNumber; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("找到次數" + count);
	}

	private static boolean isPrime(int num) {
		// TODO Auto-generated method stub

		for (int j = 2; j < num; j++) {
			if (num % j == 0) {
				// 如果可以被整除，number不是質數
				return false;
			}
		}
		// 如果整個迴圈跑完都沒有被整除，number是質數]
		return true;
	}

	@Test
	// 5.題目：利用條件運算子的巢狀來完成此題：
	// 學習成績>=90分的同學用A表示，
	// 60-89分之間的用B表示，
	// 60分以下的用C表示。
	public void ternaryOperator() {
		Scanner scan = new Scanner(System.in);
		System.out.println("輸入分數");
		int score = scan.nextInt(); // 輸入位置
		System.out.println((score >= 90) ? "A" : (score >= 60 ? "B" : "C"));
//		a ? b : c
//		當 a 為真則執行 b，當 a 為否則執行 c
		// (條件A) ? "回傳A" : (條件B) ? "回傳B" : "回傳C";
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
	// 6.題目：輸入兩個正整數m和n，求其最大公約數和最小公倍數。
	public void GCDandLCM() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入兩個正整數 m 和 n：");
		int m = scan.nextInt();
		int n = scan.nextInt();

		int gcd = findGCD(m, n);
		int lcm = (m * n) / gcd;

		System.out.println("最大公因數（GCD）: " + gcd);
		System.out.println("最小公倍數（LCM）: " + lcm);
	}

	private static int findGCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

	@Test
	// 7.題目：輸入一行字元，分別統計出其英文字母、空格、數字和其它字元的個數。
	public void CharacterStatistics() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入一行字元：");
		String input = scan.nextLine();
//
		int letterCount = 0;
		int spaceCount = 0;
		int digitCount = 0;
		int otherCount = 0;

//      for (元素類型 變數名稱 : 遍歷的集合或數組) {
//            // 執行相應的操作
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
//		System.out.println(arr[6]); //會報錯
//        System.out.println("這裡: "+Character.isDigit('1'));

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
		System.out.println("英文字母個數：" + letterCount);
		System.out.println("空格個數：" + spaceCount);
		System.out.println("數字個數：" + digitCount);
		System.out.println("其他字元個數：" + otherCount);
	}

	@Test
	// 8.題目：求s=a+aa+aaa+aaaa+aa…a的值，
	// 其中a是一個數字。假設a=2，項次為3，則輸出結果的形式如：2+22+222=246；
	public void add() {
		Scanner scan = new Scanner(System.in);
		int a;
		int n;
		int total = 0;
		System.out.println("請輸入a");
		a = scan.nextInt();// get a
		System.out.println("請輸入n");
		n = scan.nextInt();// get n
		int changeA = a; // 一開始是a

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
