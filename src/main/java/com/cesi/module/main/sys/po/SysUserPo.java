package com.cesi.module.main.sys.po;


import com.cesi.module.base.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="sys_user")
public class SysUserPo extends BasePo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String userName;
	
	private String loginCode;
	
	private String password;
	
	private String phone;
	
	private Integer state;
}
