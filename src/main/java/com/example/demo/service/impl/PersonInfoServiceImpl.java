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
			System.out.println("格式錯誤");
		}
	}

	@Override // 假設有10筆資料
	public void addInfoList(List<PersonInfo> infoList) {
		String pattern = "[A-Za-z][1-2]\\d{8}";
		for (PersonInfo item : infoList) {
			String id = item.getId();

			if (!StringUtils.hasText(id) || !id.matches(pattern)) {
				System.out.println("id error");
				return;
				// 跳出方法 與continue break做比較
			}

		}
		personInfoDao.saveAll(infoList);
		System.out.println("本次新增結果");
		for (PersonInfo item : infoList) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}
	}

	@Override
	// 2. 取得所有個人資訊
	public void findAllIdList(List<PersonInfo> infoList) {
		List<PersonInfo> result = personInfoDao.findAll();
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	};

	@Override
	// 3.透過 id 取得對應的個人資訊
	public void findByIdInfo(PersonInfo personInfo) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入身分證字號");
		String keyInId = scan.next();
		Optional<PersonInfo> infoOp = personInfoDao.findById(keyInId);
//		;
		if (infoOp.isEmpty()) {
			System.out.println("沒找到此ID");
			return;
		}
		System.out.println(infoOp.get().getId() + " " + infoOp.get().getName() + " " + infoOp.get().getAge() + " "
				+ infoOp.get().getCity());

	}

	@Override // 4.年紀大於輸入條件的所有個人資訊
	public void findAgeList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入查詢年紀");
		int keyInAge = scan.nextInt();
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThan(keyInAge);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

	@Override // 5.找出年紀小於等於輸入條件的所有個人資訊 依年齡由小到大排序
	public void findAgeLessThanEqualList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入查詢年紀");
		int keyInAge = scan.nextInt();
		List<PersonInfo> result = personInfoDao.findByAgeLessThanEqualOrderByAge(keyInAge);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

	@Override // 6.找到年齡小於輸入條件1或是大於輸入條件2的資訊
	public void findAgeBigSmallList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入查詢年紀範圍(小於第一個數或大於第二個數)");
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
	// 7.找到年紀介於2個數字之間(有包含) 的資訊
	// 以年齡由大到小排序
	// 只取前3筆資料
	public void findSevenList(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入查詢年紀範圍(找到年紀介於2個數字之間(有包含))");
		int keyInAge1 = scan.nextInt();
		int keyInAge2 = scan.nextInt();
		List<PersonInfo> result = personInfoDao.findTop3ByAgeBetweenOrderByAgeDesc(keyInAge1, keyInAge2);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

	@Override
	// 8.取得 city 包含某個特定字的所有個人資訊
	public void find8List(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入查詢居住城市(取得 city 包含某個特定字的所有個人資訊)");
		String keyInACity = scan.next();
		List<PersonInfo> result = personInfoDao.findByCityContaining(keyInACity);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}
	}

	@Override
	// 9.找出年紀大於輸入條件以及city 包含某個特定字的所有人資訊
	// 依照年齡由大到小排序
	public void find9List(List<PersonInfo> infoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入年紀和城市名稱(找出年紀大於輸入條件以及city 包含某個特定字的所有人資訊)");
		int keyInAge = scan.nextInt();
		String keyInCity = scan.next();
		
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(keyInAge,
				keyInCity);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName() + " " + item.getAge() + " " + item.getCity());
		}

	}

}