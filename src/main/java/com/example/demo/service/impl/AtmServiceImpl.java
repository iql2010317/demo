package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmDao atmDao;
	private int amount;

	@Override // 新增帳號
	public AtmResponse addInfo(String account, String pwd) {
		// 輸入不得為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// 單存檢查帳號是否存在 使用existsById回傳布林值
		if (atmDao.existsById(account)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// 密碼加密
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd), 0));
		// 不想回傳pwd
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override // 輸入帳號 取得餘額
	public AtmResponse getBalanceByAccount(String account, String pwd) {
		// 輸入不得為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// 檢查帳號內資訊 使用findById 回傳op資料型態
		Optional<Atm> op = atmDao.findById(account);
		// 找不到帳號
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		// 從op內取得res
		Atm res = op.get();
		// 加密
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 比較密碼
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		//屏蔽密碼
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) {
		// 如果輸入的參數是空的
		if (!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		//
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		Atm res = op.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(oldPwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setPwd(encoder.encode(newPwd));
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override // 存款
	public AtmResponse deposit(String account, String pwd, int depositAmount) {
		// 輸入為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || depositAmount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// 帳號為空
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		// 密碼錯誤
		Atm res = op.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		int currentBalance = res.getBalance();
		int newBalance = currentBalance + depositAmount;
		res.setBalance(newBalance);
		// 更新餘額
		atmDao.save(res);
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse withdraw(String account, String pwd, int withdrawAmount) {
		// 輸入為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || withdrawAmount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// 帳號為空
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		// 密碼錯誤
		Atm res = op.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		// 檢查餘額大於提款金額
		if (res.getBalance() < withdrawAmount) {
			res.setPwd("");
			return new AtmResponse(res, RtnCode.NOMONEY);
		}

		int currentBalance = res.getBalance();
		int newBalance = currentBalance - withdrawAmount;
		res.setBalance(newBalance);
		atmDao.save(res);
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

}
