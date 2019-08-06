package com.cesi.module.main.sys.web.rest;

import com.cesi.module.base.controller.BaseController;
import com.cesi.module.base.response.ResponseMsg;
import com.cesi.module.main.sys.po.MenuPo;
import com.cesi.module.main.sys.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value="/menu")
public class MenuController extends BaseController{

	@Autowired
	private IMenuService menuService;
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ApiOperation(value = "获取唯一人员信息", notes = "获取唯一人员信息")
	public Object page(MenuPo menu){
		return menuService.page(menu);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Object save(MenuPo menu) {
		menuService.save(menu);
		return new ResponseMsg("提交成功");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ApiOperation(value = "获取唯一人员信息", notes = "获取唯一人员信息")
	public Object delete(@ApiParam(required = true, name = "id", value = "人员ID") @RequestParam(value = "id") Integer id) {
		menuService.deleteById(id);
		return new ResponseMsg("删除成功");
	}

	@RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
	public Object batchDelete(@RequestParam(value = "ids[]") Integer[] ids) {
		menuService.batchDelete(ids);
		return new ResponseMsg("删除成功");
	}
		
}