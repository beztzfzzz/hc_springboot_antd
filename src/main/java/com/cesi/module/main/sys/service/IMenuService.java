package com.cesi.module.main.sys.service;

import com.cesi.module.base.vo.ResponsePage;
import com.cesi.module.main.sys.po.MenuPo;

import java.util.List;

public interface IMenuService {
	
	MenuPo selectById(Integer id);
	
	void updateById(MenuPo menu);
	
	void deleteById(Integer id);
	
	void insert(MenuPo menu);
	
	ResponsePage page(MenuPo menu);
	
	List<MenuPo> list(MenuPo menu);
	
	void batchDelete(Integer[] ids);
	
	void save(MenuPo menu);
	
}