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

	@Test // �s�W�@��
	public void addMenuTest() {
		// name���ű���
		Menu result = menuService.addMenu(new Menu("", 120));
		Assert.isTrue(result == null, "addmenu error");

		// price =0;
		result = menuService.addMenu(new Menu("chiken", 0));
		Assert.isTrue(result == null, "addmenu error");

		// ���`�s�W
		result = menuService.addMenu(new Menu("fish1", 120));
		Assert.isTrue(result != null, "addmenu error");

		// �s�W�w�s�b��menu
		result = menuService.addMenu(new Menu("fish1", 150));
		Assert.isTrue(result == null, "addmenu error");

		// �R�����ո��
		menuDao.deleteById("fish1");
	}

	@Test // �s�W�@��
	public void updateMenuTest() {
		// name���ű���
		Menu result = menuService.updateMenu(new Menu("", 120));
		Assert.isTrue(result == null, "updatemenu error");

		// price =0;
		result = menuService.updateMenu(new Menu("", 120));
		Assert.isTrue(result == null, "updatemenu error");
	}

	@Test
	public void findByNameTest() {
		// name���ű���
		Menu result = menuService.findByName((""));
		Assert.isTrue(result == null, "findByName error");
	}

}
