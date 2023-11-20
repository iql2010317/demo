package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest
public class MealServiceTest {

	@Autowired
	private MealService mealService;

	@Autowired
	private MealDao mealDao;

	@Test
	public void addMeal() {
		mealService.addMeal(new Meal("beef", "BBQ", 180));
		mealService.addMeal(new Meal("beef", "fry", 150));
		mealService.addMeal(new Meal("pork", "fried", 220));
		mealService.addMeal(new Meal("chicken", "stew", 260));
		mealService.addMeal(new Meal("chicken", "BBQ", 120));
		mealService.addMeal(new Meal("chicken", "steam", 120));
	}

	@Test
	public void addMealTest() {
		// name 不符條件
		Meal result = mealService.addMeal(new Meal("", "BBQ", 180));
		Assert.isTrue(result == null, "addmeal error");
		// cooking_style不符
		result = mealService.addMeal(new Meal("beef", "", 180));
		Assert.isTrue(result == null, "addmeal error");
		// price 不符
		result = mealService.addMeal(new Meal("beef", "BBQ", 0));
		Assert.isTrue(result == null, "addmeal error");
		// 正常新增
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result != null, "addmeal error");
		// 正常新增 真正添加
		result = mealService.addMeal(new Meal("pork", "BBQ", 180));
		Assert.isTrue(result != null, "addmeal error");
		// 再次新增已經存在的meal
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result == null, "addmeal error");
		// 刪除
		mealDao.deleteById(new MealId("beef", "BBQ"));
		;
	}

	@Test
	public void limitTest() {
		List<Meal> res = mealDao.findTop2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2, "find_limit_error");
	}

	@Test // findAll (By)OrderByPrice 注意命名 找尋所有 然後用價錢排序
	public void orderByTest() {
//		List<Meal> res = mealDao.findAllByOrderByPriceDesc();
		List<Meal> res = mealDao.findAllByOrderByPrice();
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	@Test // 找尋特定名稱 然後用價錢排序
	public void orderByTest1() {
		List<Meal> res = mealDao.findByNameOrderByPrice("chicken");
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	@Test // 利用價錢排序 找出大於200的商品
	public void compareTest() {
		List<Meal> res = mealDao.findByPriceGreaterThan(200);
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	@Test //
	public void containingTest() {
//		List<Meal> res = mealDao.findByNameContaining("e");
		List<Meal> res = mealDao.findByNameContainingAndCookingStyleContaining("e", "B");
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	@Test //
	public void betweenTest() {
		List<Meal> res = mealDao.findByPriceBetween(120, 260);
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	@Test //In 僅包含所列的東西
	public void inTest() {
		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(100, 120, 150, 180, 200)));
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	
	
	
}
