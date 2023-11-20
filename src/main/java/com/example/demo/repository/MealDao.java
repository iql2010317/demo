package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId> {

	// findTop數字: 限制搜尋結果回傳筆數 Top3=First3 限制筆數=3筆
	public List<Meal> findTop2ByName(String name);

	// findFirst數字: 限制搜尋結果回傳筆數
	public List<Meal> findFirst2ByName(String name);

	// orderBy: 排序:預設Asc
	// Asc:由小到大 Desc:由大到小
	public List<Meal> findAllByOrderByPrice();

	public List<Meal> findAllByOrderByPriceDesc();

	// findByName OrderByPrice
	public List<Meal> findByNameOrderByPrice(String name);

	// 比較大小:
	// 1.大於 GreaterThan //2.大於等於 GreaterThanEqual
	// 3.小於 LessThan //4.小於等於 LessThanEqual

	public List<Meal> findByPriceGreaterThan(int price);

	// 多個欄位+比較大小: 找尋名稱 And 價錢大於某數
	public List<Meal> findByNameAndPriceGreaterThan(String name, int price);

	// containing 模糊搜尋
	public List<Meal> findByNameContaining(String name);

	public List<Meal> findByNameContainingAndCookingStyleContaining(String name, String cookingStyle);

	// between 有包含上下界的值
	public List<Meal> findByPriceBetween(int price1, int price2);

	public List<Meal> findByPriceBetweenOrderByPrice(int price1, int price2);

	// In
	public List<Meal> findByPriceIn(List<Integer> priceList);

	// NotIn
	public List<Meal> findByPriceNotIn(List<Integer> priceList);

}
