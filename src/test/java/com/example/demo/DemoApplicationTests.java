package com.example.demo;

import org.junit.jupiter.api.Test;

//@SpringBootTest //暫時先註解掉
public class DemoApplicationTests {

	@Test // 可以單獨執行方法
	public void firstTest() {
		int a = 123456789;
		long b = 12L;
		System.out.println(a);
//		String str = new String("ABC"); //類別 通常寫成這個樣子
		String str = "123";
		String str1 = "ABC";
		System.out.println(str+str1);
	}

}
