package com.example.demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class RegexpTest {

	@Test
	public void regexpTest() {

		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J������X");
		String phoneNumber = scan.next();

		String regex = "09\\d{2}-\\d{3}-\\d{3}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);

		if (matcher.matches()) {
			System.out.println("����榡���T");
		} else {
			System.out.println("����榡�����T");
		}
	}

	@Test
	public void regexpTest1() {
		String str = "0912-345-678";
//		String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d";
//		String pattern = "\\d{4}-\\d{3}-\\d{3}";
		String pattern = "\\d{4}(-\\d{3}){2}";
		System.out.println(str.matches(pattern));
	}

	@Test
	public void regexpTest2() {
//		String pattern = "(\\d{2})\\d{8}"; //�榡2�X 8�X ���]�t�p�A�� �p�A���u�O���ե�
		String pattern = "\\(\\d{2}\\)\\d{8}"; //// (2�X)8�X �]�t�p�A��
	}

	@Test
	public void regexpTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J���ܸ��X");
		String phoneNumber = scan.next();
		// (02)12345678 or 02-12345678
		String pattern1 = "\\d{2,3}-\\d{7,8}"; // \\d 0~9
		// 0[1~9]{1,3}-\\d{7,8}
		String pattern2 = "\\(\\d{2,3}\\)\\d{7,8}";
		if (phoneNumber.matches(pattern1) || phoneNumber.matches(pattern2)) {
			System.out.println("���ܮ榡���T");
		} else {
			System.out.println("���ܮ榡�����T");
		}
	}

	@Test
	public void regexpTest4() {
		Scanner scan = new Scanner(System.in);

		System.out.println("�п�J�����U�K�X");
		String pwd = scan.next();

		String pattern1 = "^(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*\\d)" + "(?=.*[@#$%^&+=])" + "(?!.*[\\u4e00-\\u9fa5])"
				+ "[^\\\\s]{8,}$\r\n";

		if (pwd.matches(pattern1)) {
			System.out.println("�����U�K�X�榡���T");
		} else {
			System.out.println("�����U�K�X�榡�����T");
		}
	}

	@Test
	public void regexpTest5() {
		Scanner scan = new Scanner(System.in);
		String str = "a";
		String str1 = "Ab";
		String str2 = "abf";
		String pattern = "\\w";
		String pattern1 = "\\w.";
		String pattern2 = "\\w.*";
		System.out.println(str.matches(pattern));
		System.out.println(str1.matches(pattern));
		System.out.println("=======================");
		System.out.println(str.matches(pattern1));
		System.out.println(str1.matches(pattern1));
		System.out.println("=======================");
		System.out.println(str.matches(pattern1));
		System.out.println(str1.matches(pattern1));
		System.out.println("=======================");
		System.out.println(str2.matches(pattern));
		System.out.println(str2.matches(pattern1));
		System.out.println(str2.matches(pattern2));
	}

	@Test
	// �Ĥ@�Ӧr���^��r���j�p�g
	// �ĤG�Ӧr ��1 or2
	// �`�@10�X
	// ������,�ЦA�g�ӱư�6�����^��r��(A�BB�BD�BE�BF�BH)
	public void regexpTest6() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�����Ҹ��X");
		String keyinText = scan.next();
//		String pattern = "[A-Za-z][1-2]\\d{8}"; //�i�H
		String pattern = "[CGI-Zcgi-z][1-2]\\d{8}"; //�i�H
		System.out.println(keyinText.matches(pattern));
	}
}
