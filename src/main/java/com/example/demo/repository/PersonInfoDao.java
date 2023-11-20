package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {
	// String city 屬性名稱小寫 但方法名稱駝峰大寫
	// 自定義方法 回傳多筆 使用List
	public List<PersonInfo> findByCity(String city);

	// 而且
	public List<PersonInfo> findByNameAndCity(String name, String city);

	// 或者
	public List<PersonInfo> findByNameOrCity(String name, String city);

	// 4.年紀大於輸入條件的所有個人資訊
	public List<PersonInfo> findByAgeGreaterThan(int age);

	// 5.找出年紀小於等於輸入條件的所有個人資訊 依年齡由小到大排序
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);

	// 6.找到年齡小於輸入條件1或是大於輸入條件2的資訊
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1,int age2);

	// 7.找到年紀介於2個數字之間(有包含) 的資訊
	// 以年齡由大到小排序
	// 只取前3筆資料
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1, int age2);

	// 8.取得 city 包含某個特定字的所有個人資訊
	public List<PersonInfo> findByCityContaining(String city);

	// 9.找出年紀大於輸入條件以及city 包含某個特定字的所有人資訊
	// 依照年齡由大到小排序
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int Age,String city);

}
