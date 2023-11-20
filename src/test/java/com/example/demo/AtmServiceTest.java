package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@SpringBootTest
public class AtmServiceTest {

	@Autowired
	private AtmService atmService;

	@Test //新增使用者
	public void addInfoTest() {
		AtmResponse res = atmService.addInfo("A01", "AA123");
		System.out.println(res.getRtncode().getCode());
		System.out.println(res.getRtncode().getMessage());
		System.out.println(res.getAtm().getAccount());
		System.out.println(res.getAtm().getPwd());
	}

	@Test //取得餘額
	public void getbalanceTest() {
		AtmResponse res = atmService.getBalanceByAccount("A01", "AA123");
		System.out.println(res.getAtm().getBalance());
	}

	@Test //存款測試
	public void depositTest() {
		AtmResponse res = atmService.deposit("A01", "AA123", 600);
		System.out.println(res.getAtm().getBalance());
		System.out.println(res.getRtncode().getMessage());
	}
	
	@Test //提款測試
	public void withdrawTest() {
		AtmResponse res = atmService.withdraw("A01", "AA123", 900);
		System.out.println(res.getAtm().getBalance());
		System.out.println(res.getRtncode().getMessage());
	}
	
	
}
