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
@Table(name="sys_menu")
public class MenuPo extends BasePo{
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private String menuName;
	/**
	 * 
	 */
	private String menuLink;
	/**
	 * 
	 */
	private String createTime;
	/**
	 * 
	 */
	private String iconImage;
	/**
	 * 
	 */
	private Integer isDefault;
	/**
	 * 
	 */
	private String state;
	/**
	 * 
	 */
	private String target;
	/**
	 * 
	 */
	private Integer ord;
}