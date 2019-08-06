package com.cesi.module.base.util;

import java.util.List;

import com.cesi.module.base.vo.ResponseList;
import com.cesi.module.base.vo.ResponsePage;
import com.github.pagehelper.Page;


/**
 * Description: 
 * All Rights Reserved.
 */
public class ResponseUtil {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResponsePage parseResponPage(List datas){
		ResponsePage responPage = new ResponsePage();
		if (datas instanceof Page) {
			Page page = (Page) datas;
			responPage.setData(datas);
			responPage.setPages(page.getPages());
			responPage.setCount(page.getTotal());
		}
		return responPage;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ResponseList parseResponList(List datas){
		ResponseList responList = new ResponseList();
		responList.setData(datas);
		return responList;
	}
}
