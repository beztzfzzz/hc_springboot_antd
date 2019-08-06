package com.cesi.module.main.sys.web.rest;



import com.cesi.module.base.controller.BaseController;
import com.cesi.module.main.sys.po.SysUserPo;
import com.cesi.module.main.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sysUser")
public class SysUserController extends BaseController {
	
	@Autowired
	ISysUserService sysUserService;
	
	@RequestMapping(value = "/select")
	public SysUserPo selectById(int id){
		return sysUserService.selectById(id);
	}

}
