package com.example.demo;

import org.junit.jupiter.api.Test;

//@SpringBootTest //�Ȯɥ����ѱ�
public class DemoApplicationTests {

	@Test // �i�H��W�����k
	public void firstTest() {
		int a = 123456789;
		long b = 12L;
		System.out.println(a);
//		String str = new String("ABC"); //���O �q�`�g���o�Ӽˤl
		String str = "123";
		String str1 = "ABC";
		System.out.println(str+str1);
	}

}
