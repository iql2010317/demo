package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public void addInfo(PersonInfo personInfo) {

		String pattern = "[A-Za-z][1-2]\\d{8}";
		String id = personInfo.getId();

		if (id != null && id.matches(pattern)) {
			personInfoDao.save(personInfo);
		} else {
			System.out.println("�榡���~");
		}
	}

	@Override // ���]��10�����
	public void addInfoList(List<PersonInfo> infoList) {
		String pattern = "[A-Za-z][1-2]\\d{8}";
		for (PersonInfo item : infoList) {
			String id = item.getId();

			if (!StringUtils.hasText(id) || !id.matches(pattern)) {
				System.out.println("id error");
				return;
				// ���X��k �Pcontinue break�����
			}

		}
		personInfoDao.saveAll(infoList);
		System.out.println("�����s�W���G");
		for (PersonInfo item : infoList) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}
	}

	@Override
	// 2. ���o�Ҧ��ӤH��T
	public void findAllIdList(List<PersonInfo> infoList) {
		List<PersonInfo> result = personInfoDao.findAll();
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	};

	@Override
	// 3.�z�L id ���o�������ӤH��T
	public void findByIdInfo(PersonInfo personInfo) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�����Ҧr��");
		String keyInId = scan.next();
		Optional<PersonInfo> infoOp = personInfoDao.findById(keyInId);
//		;
		if (infoOp.isEmpty()) {
			System.out.println("�S��즹ID");
			return;
		}
		System.out.println(infoOp.get().getId() + " " + infoOp.get().getName() + " " + infoOp.get().getAge() + " "
				+ infoOp.get().getCity());

	}

	@Override // 4.�~���j���J���󪺩Ҧ��ӤH��T
	public void findAgeList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�d�ߦ~��");
		int keyInAge = scan.nextInt();
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThan(keyInAge);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

	@Override // 5.��X�~���p�󵥩��J���󪺩Ҧ��ӤH��T �̦~�֥Ѥp��j�Ƨ�
	public void findAgeLessThanEqualList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�d�ߦ~��");
		int keyInAge = scan.nextInt();
		List<PersonInfo> result = personInfoDao.findByAgeLessThanEqualOrderByAge(keyInAge);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

	@Override // 6.���~�֤p���J����1�άO�j���J����2����T
	public void findAgeBigSmallList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�d�ߦ~���d��(�p��Ĥ@�ӼƩΤj��ĤG�Ӽ�)");
		int keyInAge1 = scan.nextInt();
		int keyInAge2 = scan.nextInt();
		List<PersonInfo> result1 = personInfoDao.findByAgeLessThanOrAgeGreaterThan(keyInAge1,keyInAge2);
//		List<PersonInfo> result2 = personInfoDao.findByAgeGreaterThan(keyInAge2);
		for (PersonInfo item : result1) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}
//		for (PersonInfo item : result2) {
//			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
//		}
	}

	@Override
	// 7.���~������2�ӼƦr����(���]�t) ����T
	// �H�~�֥Ѥj��p�Ƨ�
	// �u���e3�����
	public void findSevenList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�d�ߦ~���d��(���~������2�ӼƦr����(���]�t))");
		int keyInAge1 = scan.nextInt();
		int keyInAge2 = scan.nextInt();
		List<PersonInfo> result = personInfoDao.findTop3ByAgeBetweenOrderByAgeDesc(keyInAge1, keyInAge2);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

	@Override
	// 8.���o city �]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	public void find8List(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�d�ߩ~����(���o city �]�t�Y�ӯS�w�r���Ҧ��ӤH��T)");
		String keyInACity = scan.next();
		List<PersonInfo> result = personInfoDao.findByCityContaining(keyInACity);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}
	}

	@Override
	// 9.��X�~���j���J����H��city �]�t�Y�ӯS�w�r���Ҧ��H��T
	// �̷Ӧ~�֥Ѥj��p�Ƨ�
	public void find9List(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�~���M�����W��(��X�~���j���J����H��city �]�t�Y�ӯS�w�r���Ҧ��H��T)");
		int keyInAge = scan.nextInt();
		String keyInCity = scan.next();
		
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(keyInAge,
				keyInCity);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

}