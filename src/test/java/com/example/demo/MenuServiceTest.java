package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest
public class MenuServiceTest {

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuDao menuDao;

	@Test // 新增一筆
	public void addMenuTest() {
		// name不符條件
		Menu result = menuService.addMenu(new Menu("", 120));
		Assert.isTrue(result == null, "addmenu error");

		// price =0;
		result = menuService.addMenu(new Menu("chiken", 0));
		Assert.isTrue(result == null, "addmenu error");

		// 正常新增
		result = menuService.addMenu(new Menu("fish1", 120));
		Assert.isTrue(result != null, "addmenu error");

		// 新增已存在的menu
		result = menuService.addMenu(new Menu("fish1", 150));
		Assert.isTrue(result == null, "addmenu error");

		// 刪除測試資料
		menuDao.deleteById("fish1");
	}

	@Test // 新增一筆
	public void updateMenuTest() {
		// name不符條件
		Menu result = menuService.updateMenu(new Menu("", 120));
		Assert.isTrue(result == null, "updatemenu error");

		// price =0;
		result = menuService.updateMenu(new Menu("", 120));
		Assert.isTrue(result == null, "updatemenu error");
	}

	@Test
	public void findByNameTest() {
		// name不符條件
		Menu result = menuService.findByName((""));
		Assert.isTrue(result == null, "findByName error");
	}

}
