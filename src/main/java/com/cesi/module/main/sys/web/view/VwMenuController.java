package com.cesi.module.main.sys.web.view;

import com.cesi.module.main.sys.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "//menu")
public class VwMenuController {
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		return "/menu/main";
	}
	
	@RequestMapping(value = {"/add","/edit"}, method = RequestMethod.GET)
	public String edit(Integer id, Model model) {
		model.addAttribute("menu", menuService.selectById(id));
		return "/menu/edit";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Integer id, Model model) {
		model.addAttribute("menu", menuService.selectById(id));
		return "/menu/view";
	}
}
