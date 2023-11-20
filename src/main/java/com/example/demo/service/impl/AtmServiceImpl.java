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

	@Override // �s�W�b��
	public AtmResponse addInfo(String account, String pwd) {
		// ��J���o����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// ��s�ˬd�b���O�_�s�b �ϥ�existsById�^�ǥ��L��
		if (atmDao.existsById(account)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// �K�X�[�K
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd), 0));
		// ���Q�^��pwd
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override // ��J�b�� ���o�l�B
	public AtmResponse getBalanceByAccount(String account, String pwd) {
		// ��J���o����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// �ˬd�b������T �ϥ�findById �^��op��ƫ��A
		Optional<Atm> op = atmDao.findById(account);
		// �䤣��b��
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		// �qop�����ores
		Atm res = op.get();
		// �[�K
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// ����K�X
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		//�̽��K�X
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) {
		// �p�G��J���ѼƬO�Ū�
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

	@Override // �s��
	public AtmResponse deposit(String account, String pwd, int depositAmount) {
		// ��J����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || depositAmount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// �b������
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		// �K�X���~
		Atm res = op.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		int currentBalance = res.getBalance();
		int newBalance = currentBalance + depositAmount;
		res.setBalance(newBalance);
		// ��s�l�B
		atmDao.save(res);
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse withdraw(String account, String pwd, int withdrawAmount) {
		// ��J����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || withdrawAmount <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		// �b������
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		// �K�X���~
		Atm res = op.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		// �ˬd�l�B�j�󴣴ڪ��B
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
