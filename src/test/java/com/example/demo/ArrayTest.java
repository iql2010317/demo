package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	public void arrayTest() {
		int[] a = new int[5];
		System.out.println(a);
		System.out.println(a.length);
		a[0] = 1; // ��1 ��ia�}�C�� index��0����m
		a[1] = 5;
		System.out.println(a); // @�O�����m!! new�@�����O �O���@�ӰO����Ŷ�?
		System.out.println("====================");
		int[] b = { 1, 3, 5, 7, 9 }; // �ŧi���P�ɡA�@�_����
//		System.out.println(b[4]);
		for (int item : b) {
			System.out.println(item);
		}
	}

	@Test
	public void listTest() {
		List<String> strList = new ArrayList<>();
		strList.add("A");
		strList.add("C");
		strList.add("D");
		strList.add("B");
		// List �O�����Ǫ��A�̷ӥ[�J�����ᶶ��
		System.out.println(strList);
		System.out.println("========");
		System.out.println(strList.size());
		System.out.println("========");
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("========");
		List<String> strList1 = List.of("A", "S", "D", "F");
		List<String> strList2 = Arrays.asList("A1", "S1", "D1", "F1");
		// ����U�@��{���|���� �]����List.of()���ͪ�List ��j�p�T�w�A�L�k�A�W�R
//		strList1.add("G");
		// ����U�@��{���|���� �]����Arrays.asList()���ͪ�List ��j�p�T�w�A�L�k�A�W�R
//		strList2.add("G1");
		System.out.println("===========");
		List<String> strList3 = new ArrayList<>(List.of("A", "S", "D", "F"));
		List<String> strList4 = new ArrayList<>(Arrays.asList("A1", "S1", "D1", "F1"));

	}

	@Test
	public void foreachTest() {
		List<String> strList = new ArrayList<>(List.of("A", "S", "D", "F"));

		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("===========");
		// foreach:�M���A�NList�̪��C��item�v�@���X�C
		for (String item : strList) {
			System.out.println(item);
		}
		System.out.println("===========");
		strList.forEach(item -> {

			System.out.println(item);
		});
	}

	@Test
	public void listTest1() {
		int[]a = new int[3];
		System.out.println(a.length);
		int[]b =null;
		System.out.println(b.length);
		
//		List<String> strList = new ArrayList<>();
//		List<Boolean> intList = new ArrayList<>();
	}

}
