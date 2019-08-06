package com.cesi.module.main.sys.service.impl;

import com.cesi.module.main.sys.dao.ISysUserDao;
import com.cesi.module.main.sys.po.SysUserPo;
import com.cesi.module.main.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService{
	
	@Autowired
	private ISysUserDao sysUserDao;

	@Override
	public SysUserPo selectById(int id) {
		return sysUserDao.selectByPrimaryKey(id);
	}

	@Override
	public SysUserPo getUserByLoginCode(String loginCode) {
		SysUserPo sysUserPo = new SysUserPo();
		sysUserPo.setLoginCode(loginCode);
		return sysUserDao.selectOne(sysUserPo);
	}

}
