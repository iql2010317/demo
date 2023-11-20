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
		// 1~99���Ʀr (�W����-�U����+1)+�U���� Math�O�@�����O
		double random = Math.random() * (99 - 1 + 1) + 1;
		// 20~50
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("=====================");
		Random ran = new Random();
		// Random ���O�̪� nextInt(���i):�|���� 0~�p���J���i����
		// ���� 1~99
		int a = ran.nextInt(99) + 1;

	}

	@Test
	public void guessTest() {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in); // ��J�b�o��???
		int min = 1;
		int max = 99;
		int answer = ran.nextInt(99) + 1;

		System.out.println("�����ͦ����ü�=" + answer + "(�а��˨S�ݨ�)");

		while (true) {
			System.out.printf("�вq�@��%d~%d���Ʀr", min, max);
			int guess = scan.nextInt();
			if (answer == guess) {
				System.out.printf("�q��F���׬O%d", answer);
				break; // �C���������ܭnbreak
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
