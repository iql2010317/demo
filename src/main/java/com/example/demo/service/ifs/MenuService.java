package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu;

					//���k���a��
public interface MenuService {

	public Menu addMenu(Menu menu);

	public List<Menu> addMenus(List<Menu> menuList);
	
	public Menu updateMenu(Menu menu);
	
	public Menu findByName(String name);
	
	public List<Menu> findAll();

}
