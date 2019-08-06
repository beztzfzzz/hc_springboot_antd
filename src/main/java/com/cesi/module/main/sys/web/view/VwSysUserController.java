package com.cesi.module.main.sys.web.view;


import com.cesi.module.base.controller.BaseController;
import com.cesi.module.main.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/vwuser")
public class VwSysUserController extends BaseController{
	
	@Autowired
	ISysUserService sysUserService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "sysUser/main";
	}
}
