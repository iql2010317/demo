package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@SpringBootTest
public class PersonInfoServiceTest {

	@Autowired
	private PersonInfoService addInfoService;

	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	public void addInfoServie() {
		addInfoService.addInfo(new PersonInfo("Z123356766", "zack", 35, "tainan"));
	}
	
	//1. 創建資訊
	//可創建 1~ 多筆資訊(帳號用英文字母開頭即可)
	//只能新增新資訊
	//回傳被創建的資訊、訊息
	@Test //暫時手動新增 用這個
	public void addInfoServie2() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A180032776", "ROBINSON",15, "Miaoli"));
		list.add(new PersonInfo("E152983968", "WILCOX", 20, "Taizhong"));
		list.add(new PersonInfo("J222989921", "KEITH", 23, "Jiayi"));
		list.add(new PersonInfo("R241567325", "OSBORN", 24, "Taizhong"));
		list.add(new PersonInfo("O171584733", "EATON", 28, "Jiayi"));
		list.add(new PersonInfo("I271255925", "STOKES", 30, "Tainan"));
		list.add(new PersonInfo("H111246190", "HOUSTON", 32, "Taipei"));
		list.add(new PersonInfo("H208420344", "LANG", 34, "Tainan"));
		list.add(new PersonInfo("G274308641", "RAY", 40, "Taipei"));
		list.add(new PersonInfo("K125154045", "AYALA", 45, "Tainan"));
		addInfoService.addInfoList(list);
	}

	@Test //這個不用
	public void daoSaveAllTest() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123456789", "ddd", 28, "ttt"));
		list.add(new PersonInfo("C163456780", "ddd", 28, "ttt"));
		list.add(new PersonInfo("H123486486", "haha", 28, "rrr"));
		personInfoDao.saveAll(list);
	}

	@Test
	public void daoFindTest() {
		Optional<PersonInfo> infoOp = personInfoDao.findById("A123456789");
//		;
		if (infoOp.isEmpty()) {
			System.out.println("沒找到此ID");
			return;
		}
		System.out.println((infoOp.get().getName()));
	}

	@Test
	public void daoFindTest2() {
		List<PersonInfo> list = personInfoDao.findAll();
		for (PersonInfo item : list) {
			System.out.println(item.getName());
		}
	}

	@Test
	public void daoFindTest3() {
		boolean result = personInfoDao.existsById("A123456789");
		System.out.println(result);
		// 例如；把Email當成pk ，註冊前，需要判斷Email是否存在
		// save後蓋前，只存在在Jpa裡面的save 避免後蓋前，則需要先判斷Exist;
	}

	@Test
	public void daoFindTest4() {
		List<PersonInfo> result = personInfoDao.findByCity("chayi");
		for (PersonInfo item : result) {
			System.out.println(item.getName());
		}
	}

	@Test
	//2. 取得所有個人資訊
	public void findAllIdTest() {
		addInfoService.findAllIdList(new ArrayList<>());
	}
	
	@Test
	//3.透過 id 取得對應的個人資訊
	public void findByIdTest() {
		addInfoService.findByIdInfo(new PersonInfo());
	}
	
	@Test // 4.年紀大於輸入條件的所有個人資訊
	public void compareTest() {
		addInfoService.findAgeList(new ArrayList<>());
	}

	@Test // 5.找出年紀小於等於輸入條件的所有個人資訊 依年齡由小到大排序
	public void LessThanEqualTest() {
		addInfoService.findAgeLessThanEqualList(new ArrayList<>());
	}

	@Test // 6.找到年齡小於輸入條件1或是大於輸入條件2的資訊
	public void bigSmallTest() {
		addInfoService.findAgeBigSmallList(new ArrayList<>());
	}

	@Test
	//// 7.找到年紀介於2個數字之間(有包含) 的資訊
	// 以年齡由大到小排序
	// 只取前3筆資料
	public void betweenTest() {
		addInfoService.findSevenList(new ArrayList<>());
	}

	@Test
	// 8.取得 city 包含某個特定字的所有個人資訊
	public void cityContainingTest() {
		addInfoService.find8List(new ArrayList<>());
	}

	@Test
	// 9.找出年紀大於輸入條件以及city 包含某個特定字的所有人資訊
	// 依照年齡由大到小排序
	public void ageAndCityTest() {
		addInfoService.find9List(new ArrayList<>());
	}
	

	

	
	

}
