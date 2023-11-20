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
		// name ���ű���
		Meal result = mealService.addMeal(new Meal("", "BBQ", 180));
		Assert.isTrue(result == null, "addmeal error");
		// cooking_style����
		result = mealService.addMeal(new Meal("beef", "", 180));
		Assert.isTrue(result == null, "addmeal error");
		// price ����
		result = mealService.addMeal(new Meal("beef", "BBQ", 0));
		Assert.isTrue(result == null, "addmeal error");
		// ���`�s�W
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result != null, "addmeal error");
		// ���`�s�W �u���K�[
		result = mealService.addMeal(new Meal("pork", "BBQ", 180));
		Assert.isTrue(result != null, "addmeal error");
		// �A���s�W�w�g�s�b��meal
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result == null, "addmeal error");
		// �R��
		mealDao.deleteById(new MealId("beef", "BBQ"));
		;
	}

	@Test
	public void limitTest() {
		List<Meal> res = mealDao.findTop2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2, "find_limit_error");
	}

	@Test // findAll (By)OrderByPrice �`�N�R�W ��M�Ҧ� �M��λ����Ƨ�
	public void orderByTest() {
//		List<Meal> res = mealDao.findAllByOrderByPriceDesc();
		List<Meal> res = mealDao.findAllByOrderByPrice();
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	@Test // ��M�S�w�W�� �M��λ����Ƨ�
	public void orderByTest1() {
		List<Meal> res = mealDao.findByNameOrderByPrice("chicken");
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	@Test // �Q�λ����Ƨ� ��X�j��200���ӫ~
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

	@Test //In �ȥ]�t�ҦC���F��
	public void inTest() {
		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(100, 120, 150, 180, 200)));
		for (Meal item : res) {
			System.out.println(item.getName() + " " + item.getCookingStyle() + ":" + item.getPrice());
		}
	}

	
	
	
}
