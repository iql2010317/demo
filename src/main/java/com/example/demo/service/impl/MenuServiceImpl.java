package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	// 讓他自己生成Service裡面的方法

	// @: annotation 呼叫被託管的東西
	@Autowired
	private MenuDao menuDao;

	@Override
	public Menu addMenu(Menu menu) {
		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) {
			return null;
		}
		if (!menuDao.existsById(menu.getName())) {
			return null;
		}
		return menuDao.save(menu);
//		Menu result = menuDao.save(menu);
//		return result;
	}

	@Override
	public List<Menu> addMenus(List<Menu> menuList) {
		for (Menu item : menuList) {
			if (!StringUtils.hasText(item.getName()) || item.getPrice() <= 0) {
				return null;
			}
		}
		return menuDao.saveAll(menuList);
	}

	@Override
	public Menu updateMenu(Menu menu) {
		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) {
			return null;
		}
		if (!menuDao.existsById(menu.getName())) {
			return null;
		}
		return menuDao.save(menu);
	}

	@Override
	public Menu findByName(String name) {
		if (!StringUtils.hasText(name)) {
			return null;
		}
		Optional<Menu> op = menuDao.findById(name);
//		return op.orElseGet(null);
		// 有東西就回傳op.get 不然就回傳null
		if (op.isEmpty()) {
			return null;
		}
		return op.get(); //寫法1

//		Menu menu=op.isEmpty() ? null : op.get();
//		return menu; //寫法2

//		return op.isEmpty() ? null : op.get(); //三元 寫法3

	}

	@Override
	public List<Menu> findAll() {
		return menuDao.findAll();
	}

}
