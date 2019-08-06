package com.cesi.module.main.sys.service;

import com.cesi.module.main.sys.po.SysUserPo;

public interface ISysUserService {
	
	SysUserPo selectById(int id);

	SysUserPo getUserByLoginCode(String loginCode);
}
