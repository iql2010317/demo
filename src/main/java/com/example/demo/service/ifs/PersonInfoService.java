package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.PersonInfo;

public interface PersonInfoService {

	public void addInfo(PersonInfo personInfo);

	void addInfoList(List<PersonInfo> infoList);


	// 2. 取得所有個人資訊
	void findAllIdList(List<PersonInfo> infoList);

	// 3.透過 id 取得對應的個人資訊
	void findByIdInfo(PersonInfo personInfo);

	// 4.年紀大於輸入條件的所有個人資訊
	void findAgeList(List<PersonInfo> infoList);

	// 5.找出年紀小於等於輸入條件的所有個人資訊 依年齡由小到大排序
	void findAgeLessThanEqualList(List<PersonInfo> infoList);

	// 6.找到年齡小於輸入條件1或是大於輸入條件2的資訊
	void findAgeBigSmallList(List<PersonInfo> infoList);

	// 7.找到年紀介於2個數字之間(有包含) 的資訊
	// 以年齡由大到小排序
	// 只取前3筆資料
	void findSevenList(List<PersonInfo> infoList);

	// 8.取得 city 包含某個特定字的所有個人資訊
	void find8List(List<PersonInfo> infoList);

	// 9.找出年紀大於輸入條件以及city 包含某個特定字的所有人資訊
	// 依照年齡由大到小排序
	void find9List(List<PersonInfo> infoList);

}
