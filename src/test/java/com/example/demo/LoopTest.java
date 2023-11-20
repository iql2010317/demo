package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class LoopTest {

	@Test
	public void loopTest() {
		System.out.println("======="); // 1 2 4 3
		for (int i = 1; i < 5; i++) {
			System.out.println("i=" + i);
		}
		System.out.println("======="); // 1 2 4 3
		for (int i = 1; i < 5; ++i) {
			System.out.println("i=" + i);
		}
	}

	@Test
	public void loopTest2() {
		for (int i = 1; i <= 9; i++) {
//			if (i == 2) {
//				break;
//			}
			for (int j = 1; j <= 9; j++) {
//				if (j == 2) {
//					break;
//				}
				System.out.printf("%d*%d=%2d ", i, j, (i * j));
			}
			System.out.println("");
		}
	}

	@Test
	public void randomTest() {
		// 1~99的數字 (上限值-下限值+1)+下限值 Math是一個類別
		double random = Math.random() * (99 - 1 + 1) + 1;
		// 20~50
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("=====================");
		Random ran = new Random();
		// Random 類別裡的 nextInt(整數i):會產生 0~小於輸入整數i的值
		// 產生 1~99
		int a = ran.nextInt(99) + 1;

	}

	@Test
	public void guessTest() {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in); // 輸入在這裡???
		int min = 1;
		int max = 99;
		int answer = ran.nextInt(99) + 1;

		System.out.println("本次生成的亂數=" + answer + "(請假裝沒看到)");

		while (true) {
			System.out.printf("請猜一個%d~%d的數字", min, max);
			int guess = scan.nextInt();
			if (answer == guess) {
				System.out.printf("猜對了答案是%d", answer);
				break; // 遊戲結束的話要break
			}
			if (guess > max || guess < min) {
//				continue;
			}
			if (guess > answer) {
				max = guess;
			}
			if (guess < answer) {
				min = guess;
			}
		}
	}

}
