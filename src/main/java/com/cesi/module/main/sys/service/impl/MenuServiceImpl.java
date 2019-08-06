package com.cesi.module.main.sys.service.impl;

import com.cesi.module.base.util.ResponseUtil;
import com.cesi.module.base.vo.ResponsePage;
import com.cesi.module.main.sys.po.MenuPo;
import com.cesi.module.main.sys.dao.IMenuDao;
import com.cesi.module.main.sys.service.IMenuService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;
	
	@Override
	public MenuPo selectById(Integer id){
		log.debug("id");
		return menuDao.selectByPrimaryKey(id);
	}
	
	@Override
	public ResponsePage page(MenuPo menu){
		PageHelper.startPage(menu.getPage(), menu.getLimit(), "id desc");
		return ResponseUtil.parseResponPage(menuDao.select(menu));
	}
	
	@Override
	public List<MenuPo> list(MenuPo menu){
        return menuDao.select(menu);
	}
	
	@Override
	public void insert(MenuPo menu){
		menuDao.insertSelective(menu);
	}
	
	@Override
	public void updateById(MenuPo menu){
		menuDao.updateByPrimaryKey(menu);
	}
	
	@Override
	public void deleteById(Integer id){
		menuDao.deleteByPrimaryKey(id);
	}
	
	@Override
	public void batchDelete(Integer[] ids) {
		if(ids==null) {
			return ;
		}
		for(Integer id:ids) {
			this.deleteById(id);
		}
	}

	@Override
	public void save(MenuPo menu) {
		if(menu.getId() == null) {
			menuDao.insert(menu);
		}else {
			this.updateByPrimaryKey(menu);
		}
		
	}
	
	private void updateByPrimaryKey(MenuPo menu) {
		MenuPo dbPo = menuDao.selectByPrimaryKey(menu.getId());
		menuDao.updateByPrimaryKey(menu);
	}
	
}